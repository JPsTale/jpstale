# C++ (pristontale-1) 与 jME3-core 数学模块对比

## 1. 四元数定义与存储

### 1.1 分量顺序与命名

| 项目 | C++ (pristontale-1) | jME3 (jme3-core) |
|------|---------------------|------------------|
| 存储顺序 | `qx, qy, qz, qw` (smOBJ3d.h) | `x, y, z, w` (Quaternion.java) |
| 含义 | 3 个虚部 + 1 个实部 | "3 imaginary (X,Y,Z) and a real component (W)"，W 在最后 |
| 单位四元数 | (0, 0, 0, 1) 未在源码中写死，但 D3DMath_QuaternionSlerp 等用 0,0,0,0 与 bx,by,bz,bw 插值 | `IDENTITY = (0, 0, 0, 1)` |

结论：**分量顺序一致，都是 (x, y, z, w)，即 (qx, qy, qz, qw)。**

---

### 1.2 四元数 → 旋转矩阵公式

**C++** `smmatrix.cpp` — `smMatrixFromQuaternion(smMATRIX& mat, float x, float y, float z, float w)`：

```cpp
mat._11 = 1 - 2*(yy+zz);   _12 = 2*(xy - wz);   _13 = 2*(xz + wy);
mat._21 = 2*(xy + wz);     _22 = 1 - 2*(xx+zz); _23 = 2*(yz - wx);
mat._31 = 2*(xz - wy);     _32 = 2*(yz + wx);   _33 = 1 - 2*(xx+yy);
```

**jME3** `Quaternion.java` — `toRotationMatrix(Matrix3f result)`：

```java
result.m00 = 1 - (yy + zz);  m01 = (xy - zw);  m02 = (xz + yw);
result.m10 = (xy + zw);      m11 = 1 - (xx + zz);  m12 = (yz - xw);
result.m20 = (xz - yw);      m21 = (yz + xw);  m22 = 1 - (xx + yy);
```

其中 jME3 用 `s = 2/norm` 把系数 2 吸收进 xs/ys/zs（如 `zw = w*zs`），因此与 C++ 的 `2*(xy - wz)` 等完全对应。

结论：**四元数 (x,y,z,w) 转旋转矩阵的公式一致。**

---

### 1.3 旋转矩阵 → 四元数

**C++** `smDQuaternionFromMatrix` / `smFQuaternionFromMatrix`（trace 分支）：

- `x = (mat._23 - mat._32) / (2*s)`
- `y = (mat._31 - mat._13) / (2*s)`
- `z = (mat._12 - mat._21) / (2*s)`
- `w = 0.5f * s`

**jME3** `Quaternion.fromRotationMatrix(m00..m22)`（trace >= 0 分支）：

- `x = (m21 - m12) * s`
- `y = (m02 - m20) * s`
- `z = (m10 - m01) * s`
- `w = 0.5f * s`（s 的求法略不同，但都是基于 trace）

C++ 的 `_23` = 第 2 行第 3 列 = jME 的 `m12`，`_32` = jME 的 `m21`，故 `_23 - _32` = `m12 - m21`，而 jME 是 `m21 - m12`，差一个负号。对四元数而言 **q 与 -q 表示同一旋转**，因此矩阵→四元数在两种实现下给出的是**同一旋转的两种等价四元数**（可能差整体符号）。

结论：**矩阵→四元数在数学上等价，仅可能差 q 与 -q；对旋转结果无影响。**

---

### 1.4 C++ 的 axis-angle → 四元数

**C++** `smQuaternionFromAxis(float &x, float &y, float &z, float &w)`（注释 `w -> angle`）：

- 入参：轴 (x,y,z)，**w 存的是角度（不是四元数 w）**
- 计算：`fHalfAngle = w/2`，`d = cos(fHalfAngle)`，`a = sn*x, b = sn*y, c = sn*z`（sn = sin(fHalfAngle)）
- 出参：`(x,y,z,w) = (a, b, c, d)`，即四元数 `(axis*sin(θ/2), cos(θ/2))`

与 jME3 / 我们 loader 里 TransRotation 的 axis-angle 约定（轴 + cosHalfAngle）在语义上一致，都是标准 half-angle 四元数构造。

---

## 2. 矩阵存储与向量乘法

### 2.1 存储布局

| 项目 | C++ (smType.h) | jME3 (Matrix4f) |
|------|----------------|-----------------|
| 布局 | `_11,_12,_13,_14; _21,_22,_23,_24; ...` 行主序（row-major） | `m00,m01,m02,m03; m10,m11,...` 行主序，注释 "Element numbering is (row,column)" |
| 第 0 行 | _11 _12 _13 _14 | m00 m01 m02 m03 |
| 平移列 | _14, _24, _34, _44 | m03, m13, m23, m33（"rightmost column (column 3) stores the translation"） |

结论：**都是行主序；平移都在第 4 列（第 3 列 in 0-based）。**

---

### 2.2 矩阵 × 向量（顶点变换）

**C++** `smObj3d.cpp` ReformTM / ReformPhysique：

```cpp
x = Vertex[cnt].x * q._11 + Vertex[cnt].y * q._21 + Vertex[cnt].z * q._31;
y = Vertex[cnt].x * q._12 + Vertex[cnt].y * q._22 + Vertex[cnt].z * q._32;
z = Vertex[cnt].x * q._13 + Vertex[cnt].y * q._23 + Vertex[cnt].z * q._33;
Vertex[cnt].x = (x>>FLOATNS) + q._41;  // 同理 _42, _43
```

即：**out.x = v·(列0) + _41**，用的是矩阵的**第 1 列** (_11,_21,_31) 与平移 _41。因此 C++ 实际是 **列向量在右：M_column * v**，即存储的是行主序，但**乘法时按列取**，等价于用 **M 的转置** 按“行×向量”来算。也就是说：**C++ 里实际施加在顶点上的变换是存储矩阵的转置**。

**jME3** `Matrix4f.mult(Vector3f vec, Vector3f store)`：

```java
store.x = m00 * vx + m01 * vy + m02 * vz + m03;
store.y = m10 * vx + m11 * vy + m12 * vz + m13;
store.z = m20 * vx + m21 * vy + m22 * vz + m23;
```

即：**out = 行 × 向量**，**行主序存储，行×向量**，即 **M_row * v**。

因此：

- C++：存储 T（行主序），顶点变换实际是 **T^T * v**。
- jME3：存储 M（行主序），顶点变换是 **M * v**。

若同一逻辑在两边都要得到相同结果，则需 **M = T^T**，即 **在 Java 里用的矩阵应是 C++ 存储矩阵的转置**。这与 loader 里对 `transformInvert` 的用法一致：`valueIT = value.transpose().invertLocal()`，即对“文件中的矩阵”做了转置再取逆后用于顶点，和 C++ 的“存 T、用 T^T”的乘法约定是配套的。

---

## 3. 小结与对 loader 的启示

| 项目 | 是否一致 | 说明 |
|------|----------|------|
| 四元数分量顺序 (x,y,z,w) | 一致 | 两边都是 (qx,qy,qz,qw) / (x,y,z,w) |
| 四元数 → 旋转矩阵 | 一致 | 公式逐项对应 |
| 旋转矩阵 → 四元数 | 等价 | 可能差 q 与 -q，旋转一致 |
| 矩阵存储 | 一致 | 均为行主序，平移在第 4 列 |
| 矩阵 × 向量 | **约定不同** | C++ 用“存储矩阵的转置”乘向量；jME3 用“存储矩阵”乘向量，故同一变换在文件中若按 C++ 行主序存，在 jME 中应取转置再参与运算 |

对 JPsTale loader 的启示：

1. **四元数**：C++ 与 jME3 定义一致，用 (qx, qy, qz, qw) 直接构造 jME3 的 `Quaternion` 在公式上没问题。若出现“扭 90°”等现象，更可能来自：**bind 与顶点所用矩阵是否同源、以及矩阵在 Java 侧是否按“转置/逆”正确换算**，而不是四元数定义不同。
2. **顶点变换**：loader 已用 `valueIT = value.transpose().invertLocal()` 与 C++ 的“存 T、用 T^T 乘顶点”约定对齐；bind 若从同一矩阵推导，需在同一约定下（即考虑转置关系）取逆或转置，与当前 `invertPoint` 的用法一致。
3. **-qw 的由来**：若 C++ 导出或中间格式里对 w 有取反（例如某些 D3D 工具链），则 loader 里对 `qw` 取反（-qw）可能是为了抵消该约定，而不是因为 jME3 与 C++ 的四元数数学定义不同。

---

## 4. 参考源码路径

- **C++**  
  - 四元数/矩阵：`pristontale-1/src/smLib3d/smmatrix.cpp`（smMatrixFromQuaternion, smFMatrixFromQuaternion, smDQuaternionFromMatrix, smFQuaternionFromMatrix）  
  - 矩阵类型：`pristontale-1/src/smLib3d/smType.h`（smMATRIX, smFMATRIX）  
  - 顶点变换：`pristontale-1/src/smLib3d/smObj3d.cpp`（ReformTM, ReformPhysique）  
  - 对象四元数字段：`pristontale-1/src/smLib3d/smObj3d.h`（qx,qy,qz,qw）
- **jME3**  
  - 四元数：`jmonkeyengine/jme3-core/src/main/java/com/jme3/math/Quaternion.java`  
  - 矩阵：`jmonkeyengine/jme3-core/src/main/java/com/jme3/math/Matrix4f.java`
