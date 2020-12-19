package org.pstale.assets.gltf;

import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

import org.pstale.assets.gltf.entity.Accessor;
import org.pstale.assets.gltf.entity.BufferView;
import org.pstale.assets.gltf.entity.Mesh;
import org.pstale.assets.gltf.entity.MeshPrimitive;
import org.pstale.assets.gltf.enums.ComponentType;
import org.pstale.assets.gltf.enums.GltfType;
import org.pstale.assets.gltf.enums.Target;
import org.pstale.assets.gltf.enums.VertexAttribute;

import java.util.ArrayList;
import java.util.List;

public class Submesh {
	int matId;

	int[] indices;

	Vector3f[] position;

	Vector3f[] normal;

	Vector2f[] texCoord;

	ColorRGBA[] color;

	byte[] data = null;

	int baseOffset = 0;

	int indicesOffset;
	int indicesLength;
	int indicesPadding;

	int positionOffset;
	int positionLength;

	int texCoordOffset;
	int texCoordLength;

	int colorOffset;
	int colorLength;

	int normalOffset;
	int normalLength;

	int length = 0;

	public int getLength() {
		indicesLength = indices.length * 4;// SCALAR UNSIGNED_INT
		indicesPadding = indicesLength % 4;
		if (indicesPadding != 0) {
			indicesPadding = 4 - indicesPadding;// 如果索引数是奇数，那么就需要增加2个字节来进行对齐
		}

		positionLength = position.length * 12;// VEC3 FLOAT

		texCoordLength = texCoord.length * 8;// VEC2 FLOAT

		colorLength = 0;
		if (color != null) {
			colorLength = color.length * 16;// VEC4 FLOAT
		}

		normalLength = 0;
		if (normal != null) {
			normalLength = normal.length * 12;// VEC3 FLOAT
		}

		length = indicesLength + indicesPadding + positionLength + texCoordLength + colorLength + normalLength;
		return length;
	}

	public void setBaseOffset(int baseOffset) {
		this.baseOffset = baseOffset;

		indicesOffset = baseOffset;

		positionOffset = indicesOffset + indicesLength + indicesPadding;

		texCoordOffset = positionOffset + positionLength;

		colorOffset = texCoordOffset + texCoordLength;

		normalOffset = colorOffset + colorLength;
	}

	public byte[] data(byte[] data) {
		if (data == null) {
			data = new byte[getLength()];
		}

		int offset = 0;
		// indices
		for (int v : indices) {
			writeInt(data, v, offset);
			offset += 4;
		}
		// for data alignment
		offset += indicesPadding;

		// positions
		for (Vector3f v : position) {
			writeFloat(data, v.x, offset);
			writeFloat(data, v.y, offset + 4);
			writeFloat(data, v.z, offset + 8);
			offset += 12;
		}

		// texCoords
		for (Vector2f v : texCoord) {
			writeFloat(data, v.x, offset);
			writeFloat(data, v.y, offset + 4);
			offset += 8;
		}

		// colors
		if (color != null) {
			for (ColorRGBA v : color) {
				writeFloat(data, v.r, offset);
				writeFloat(data, v.g, offset + 4);
				writeFloat(data, v.b, offset + 8);
				writeFloat(data, v.a, offset + 12);
				offset += 16;
			}
		}

		// normals
		if (normal != null) {
			for (Vector3f v : normal) {
				writeFloat(data, v.x, offset);
				writeFloat(data, v.y, offset + 4);
				writeFloat(data, v.z, offset + 8);
				offset += 12;
			}
		}

		return data;
	}

	public byte[] data() {
		if (data == null) {
			data = new byte[getLength()];
		}

		return data(data);

	}

	void writeShort(byte[] data, int v, int offset) {
		data[offset + 0] = (byte) ((v >>> 0) & 0xFF);
		data[offset + 1] = (byte) ((v >>> 8) & 0xFF);
	}

	void writeInt(byte[] data, int v, int offset) {
		data[offset + 0] = (byte) ((v >>> 0) & 0xFF);
		data[offset + 1] = (byte) ((v >>> 8) & 0xFF);
		data[offset + 2] = (byte) ((v >>> 16) & 0xFF);
		data[offset + 3] = (byte) ((v >>> 24) & 0xFF);
	}

	void writeFloat(byte[] data, float f, int offset) {
		int v = Float.floatToRawIntBits(f);

		data[offset + 0] = (byte) ((v >>> 0) & 0xFF);
		data[offset + 1] = (byte) ((v >>> 8) & 0xFF);
		data[offset + 2] = (byte) ((v >>> 16) & 0xFF);
		data[offset + 3] = (byte) ((v >>> 24) & 0xFF);
	}

	// 索引
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;

	void indexMaxMin() {
		for (int i : indices) {
			if (i > max)
				max = i;
			if (i < min)
				min = i;
		}
	}

	// 坐标
	Vector3f pMax = new Vector3f(Vector3f.NEGATIVE_INFINITY);
	Vector3f pMin = new Vector3f(Vector3f.POSITIVE_INFINITY);

	void positionMaxMin() {
		for (Vector3f v : position) {

			if (v.x > pMax.x)
				pMax.x = v.x;
			if (v.y > pMax.y)
				pMax.y = v.y;
			if (v.z > pMax.z)
				pMax.z = v.z;

			if (v.x < pMin.x)
				pMin.x = v.x;
			if (v.y < pMin.y)
				pMin.y = v.y;
			if (v.z < pMin.z)
				pMin.z = v.z;
		}
	}

	// 颜色
	Vector4f cMax = new Vector4f(Vector4f.NEGATIVE_INFINITY);
	Vector4f cMin = new Vector4f(Vector4f.POSITIVE_INFINITY);

	void colorMaxMin() {
		if (color != null) {
			for (ColorRGBA v : color) {

				if (v.r > cMax.x)
					cMax.x = v.r;
				if (v.g > cMax.y)
					cMax.y = v.g;
				if (v.b > cMax.z)
					cMax.z = v.b;
				if (v.a > cMax.w)
					cMax.w = v.a;

				if (v.r < cMin.x)
					cMin.x = v.r;
				if (v.g < cMin.y)
					cMin.y = v.g;
				if (v.b < cMin.z)
					cMin.z = v.b;
				if (v.a < cMin.w)
					cMin.w = v.a;
			}
		}
	}

	// 坐标
	Vector2f uvMax = new Vector2f(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
	Vector2f uvMin = new Vector2f(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);

	void texCoordMaxMin() {
		for (Vector2f v : texCoord) {

			if (v.x > uvMax.x)
				uvMax.x = v.x;
			if (v.y > uvMax.y)
				uvMax.y = v.y;

			if (v.x < uvMin.x)
				uvMin.x = v.x;
			if (v.y < uvMin.y)
				uvMin.y = v.y;
		}
	}

	// 法线
	Vector3f nMax = new Vector3f(Vector3f.NEGATIVE_INFINITY);
	Vector3f nMin = new Vector3f(Vector3f.POSITIVE_INFINITY);

	void normalMaxMin() {
		if (normal != null) {
			for (Vector3f v : normal) {

				if (v.x > nMax.x)
					nMax.x = v.x;
				if (v.y > nMax.y)
					nMax.y = v.y;
				if (v.z > nMax.z)
					nMax.z = v.z;

				if (v.x < nMin.x)
					nMin.x = v.x;
				if (v.y < nMin.y)
					nMin.y = v.y;
				if (v.z < nMin.z)
					nMin.z = v.z;
			}
		}
	}

	/**
	 * 计算最大值、最小值
	 */
	public void getMaxMin() {
		// 索引
		indexMaxMin();

		// 坐标
		positionMaxMin();

		// 颜色
		colorMaxMin();

		// 纹理坐标
		texCoordMaxMin();

		// 法线
		normalMaxMin();
	}

	public List<BufferView> getBufferViews() {

		List<BufferView> bufferViews = new ArrayList<BufferView>();

		// indices
		BufferView bv = new BufferView();
		bufferViews.add(bv);

		bv.setName("indicesBufferView" + matId);
		bv.setByteOffset(indicesOffset);
		bv.setByteLength(indicesLength);
		bv.setTarget(Target.VERTEX_INDIX.getValue());

		// vertex position
		bv = new BufferView();
		bufferViews.add(bv);

		bv.setName("positionsBufferView" + matId);
		bv.setByteOffset(positionOffset);
		bv.setByteLength(positionLength);
		bv.setTarget(Target.VERTEX_ATTRIBUTE.getValue());

		// texture coordination
		bv = new BufferView();
		bufferViews.add(bv);

		bv.setName("texCoord0BufferView" + matId);
		bv.setByteOffset(texCoordOffset);
		bv.setByteLength(texCoordLength);

		// vertex color
		if (color != null) {
			bv = new BufferView();
			bufferViews.add(bv);

			bv.setName("colors0BufferView" + matId);
			bv.setByteOffset(colorOffset);
			bv.setByteLength(colorLength);
		}

		// vertex normal
		if (normal != null) {
			bv = new BufferView();
			bufferViews.add(bv);

			bv.setName("normalsBufferView" + matId);
			bv.setByteOffset(normalOffset);
			bv.setByteLength(normalLength);
		}

		return bufferViews;
	}

	public List<Accessor> getAccessors(int idx) {
		// BufferView idx
		int bvIdx = 0;

		List<Accessor> accessors = new ArrayList<Accessor>();

		// indices
		Accessor acc = new Accessor();
		accessors.add(acc);

		acc.setName("index_" + matId);
		acc.setBufferView(idx + bvIdx);
		acc.setComponentType(ComponentType.UNSIGNED_INT.getValue());
		acc.setType(GltfType.SCALAR.name());
		acc.setCount(indices.length);
		acc.setMax(new Integer[] { max });
		acc.setMin(new Integer[] { min });

		bvIdx++;

		// positions
		acc = new Accessor();
		accessors.add(acc);

		acc.setName("position_" + matId);
		acc.setBufferView(idx + bvIdx);
		acc.setComponentType(ComponentType.FLOAT.getValue());
		acc.setType(GltfType.VEC3.name());
		acc.setCount(position.length);
		acc.setMax(new Float[] { pMax.x, pMax.y, pMax.z });
		acc.setMin(new Float[] { pMin.x, pMin.y, pMin.z });

		bvIdx++;

		// texCoord
		acc = new Accessor();
		accessors.add(acc);

		acc.setName("texcoord0_" + matId);
		acc.setBufferView(idx + bvIdx);
		acc.setComponentType(ComponentType.FLOAT.getValue());
		acc.setType(GltfType.VEC2.name());
		acc.setCount(texCoord.length);
		acc.setMax(new Float[] { uvMax.x, uvMax.y });
		acc.setMin(new Float[] { uvMin.x, uvMin.y });

		bvIdx++;

		// colors
		if (color != null) {
			acc = new Accessor();
			accessors.add(acc);

			acc.setName("color0_" + matId);
			acc.setBufferView(idx + bvIdx);
			acc.setComponentType(ComponentType.FLOAT.getValue());
			acc.setType(GltfType.VEC4.name());
			acc.setCount(color.length);
			acc.setMax(new Float[] { cMax.x, cMax.y, cMax.z, cMax.w });
			acc.setMin(new Float[] { cMin.x, cMin.y, cMin.z, cMin.w });

			bvIdx++;
		}

		// normals
		if (normal != null) {
			acc = new Accessor();
			accessors.add(acc);

			acc.setName("normal_" + matId);
			acc.setBufferView(idx + bvIdx);
			acc.setComponentType(ComponentType.FLOAT.getValue());
			acc.setType(GltfType.VEC3.name());
			acc.setCount(normal.length);
			acc.setMax(new Float[] { nMax.x, nMax.y, nMax.z });
			acc.setMin(new Float[] { nMin.x, nMin.y, nMin.z });

			bvIdx++;
		}

		return accessors;
	}

	public Mesh getMesh(int idx) {
		// BufferView idx
		int bvIdx = 0;

		List<MeshPrimitive> primitives = new ArrayList<>();

		MeshPrimitive primitive = new MeshPrimitive();
		primitive.setMaterial(matId);
		
		primitive.setIndices(idx + bvIdx);
		bvIdx++;
		
		primitive.addAttributes(VertexAttribute.POSITION.name(), idx +bvIdx);
		bvIdx++;
		
		primitive.addAttributes(VertexAttribute.TEXCOORD_0.name(), idx + bvIdx);
		bvIdx++;

		if (color != null) {
			primitive.addAttributes(VertexAttribute.COLOR_0.name(), idx + bvIdx);
			bvIdx++;
		}
		
		if (normal != null) {
			primitive.addAttributes(VertexAttribute.NORMAL.name(), idx + bvIdx);
			bvIdx++;
		}

		primitives.add(primitive);

		Mesh mesh = new Mesh();
		mesh.setName("mesh" + matId);
		mesh.setPrimitives(primitives);

		return mesh;
	}

	/**
	 * @return
	 */
	public boolean hasNormal() {
		return normal != null;
	}
}