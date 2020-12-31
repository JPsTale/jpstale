package org.jpstale.app;

import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.MeshCollisionShape;
import com.jme3.bullet.objects.PhysicsRigidBody;
import com.jme3.collision.CollisionResults;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 碰撞检测模块
 * 
 * @author yanmaoyuan
 * 
 */
public class CollisionState extends BaseAppState {

    static Logger log = Logger.getLogger(CollisionState.class);

    /**
     * 射线检测
     */
    List<Mesh> meshes;// 参加检测的网格
    Vector3f origin = new Vector3f();// 射线检测的原点
    // 射线，初始化为从原点出发，方向垂直向下。
    Ray ray = new Ray(origin, new Vector3f(0, -1, 0));
    // 检测结果
    CollisionResults results = new CollisionResults();

    // 所有地形的网格
    List<PhysicsRigidBody> rigids;
    BulletAppState bullet;

    public CollisionState() {
        meshes = new ArrayList<Mesh>(100);
        rigids = new ArrayList<PhysicsRigidBody>(100);
        bullet = new BulletAppState();
        bullet.setDebugEnabled(false);
    }

    @Override
    protected void initialize(Application app) {
    }

    @Override
    protected void cleanup(Application app) {
    }

    @Override
    protected void onEnable() {
        getStateManager().attach(bullet);
    }

    @Override
    protected void onDisable() {
        getStateManager().detach(bullet);
    }

    public void addMesh(Mesh mesh) {
        if (meshes.contains(mesh))
            return;

        if (getStateManager().hasState(bullet)) {
            MeshCollisionShape shape = new MeshCollisionShape(mesh);

            PhysicsRigidBody rigid = new PhysicsRigidBody(shape, 0);
            rigid.setFriction(1);
            bullet.getPhysicsSpace().add(rigid);

            meshes.add(mesh);
            rigids.add(rigid);
        }
    }

    public void debug(Boolean debug) {
        bullet.setDebugEnabled(debug);
    }

}
