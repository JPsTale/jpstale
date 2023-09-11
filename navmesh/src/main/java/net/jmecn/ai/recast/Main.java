package net.jmecn.ai.recast;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.material.Materials;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.system.AppSettings;
import org.jpstale.assets.AssetFactory;
import org.recast4j.detour.NavMesh;
import org.recast4j.detour.NavMeshQuery;
import org.recast4j.detour.QueryFilter;
import org.recast4j.detour.crowd.Crowd;
import org.recast4j.detour.crowd.CrowdAgent;
import org.recast4j.detour.crowd.CrowdAgentParams;
import org.recast4j.detour.tilecache.TileCache;
import org.recast4j.detour.tilecache.TileCacheCompressor;
import org.recast4j.detour.tilecache.TileCacheParams;
import org.recast4j.recast.*;
import org.recast4j.recast.geom.TriMesh;

/**
 * desc:
 *
 * @author yanmaoyuan
 * @date 2023/9/11
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        AppSettings settings = new AppSettings(true);
        settings.setTitle("Recast4j Navigation Demo");
        app.setSettings(settings);
        app.start();
    }

    private static final float AGENT_HEIGHT = 2.0f;
    private static final float AGENT_RADIUS = 0.6f;
    private static final float AGENT_MAX_CLIMB = 0.9f;
    private static final float AGENT_MAX_SLOPE = 45.0f;
    private static final float CELL_SIZE = 0.3f;
    private static final float CELL_HEIGHT = 0.2f;
    private static final float AGENT_MAX_ACCELERATION = 8.0f;
    private static final float AGENT_MAX_SPEED = 2.5f;
    private static final float AGENT_COLLISION_QUERY_RANGE = AGENT_RADIUS * 12.0f;
    private static final float AGENT_PATH_OPTIMIZATION_RANGE = AGENT_RADIUS * 30.0f;
    private static final float AGENT_SEPARATION_WEIGHT = 2.0f;
    private static final float TILE_SIZE = 48;
    private static final int MAX_TILES = 128;
    private static final int MAX_POLYS_PER_TILE = 32768;

    private Mesh mesh;
    private TriMesh triMesh;

    private NavMesh navMesh;
    private NavMeshQuery navMeshQuery;
    private Crowd crowd;
    private TileCache tileCache;
    private TileCacheParams tileCacheParams;
    private TileCacheAlloc tileCacheAlloc;
    private TileCacheCompressor tileCacheCompressor;
    private QueryFilter queryFilter;
    private CrowdAgentParams crowdAgentParams;
    private CrowdAgent crowdAgent;
    private Vector3f targetPosition;

    @Override
    public void simpleInitApp() {
        /**
         * 设置模型工厂
         */
        AssetFactory.setAssetManager(assetManager);
        flyCam.setMoveSpeed(50);
        flyCam.setDragToRotate(true);

        // 初始化导航网格
        initNavMesh();

        // 初始化导航查询
        initNavMeshQuery();

        // 初始化人群
        initCrowd();

        // 初始化寻路代理
        initCrowdAgent();

        // 初始化寻路目标
        initTargetPosition();

        // 设置摄像机初始位置和方向
        cam.setLocation(new Vector3f(-20, 20, -20));
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
    }

    private void loadTerrainGeometry() {
        mesh = AssetFactory.loadStage3DMesh("Field/forest/fore-1.ASE");
        triMesh = Jme3ToRecast4jConverter.convertMeshToGeometry(mesh);
    }

    private void initNavMesh() {
        // 生成导航网格
        // 计算网格数据
        RecastConfig recastConfig = new RecastConfig();

        RecastBuilderConfig builderConfig = new RecastBuilderConfig();
        builderConfig.walkableSlopeAngle = AGENT_MAX_SLOPE;
        builderConfig.walkableHeight = (int) Math.ceil(AGENT_HEIGHT / CELL_HEIGHT);
        builderConfig.walkableClimb = (int) Math.floor(AGENT_MAX_CLIMB / CELL_HEIGHT);
        builderConfig.walkableRadius = (int) Math.ceil(AGENT_RADIUS / CELL_SIZE);
        builderConfig.maxEdgeLen = (int) (12 / CELL_SIZE);
        builderConfig.maxSimplificationError = 1.3f;
        builderConfig.minRegionArea = 8;
        builderConfig.mergeRegionArea = 20;
        builderConfig.maxVertsPerPoly = 6;
        builderConfig.detailSampleDist = 6;
        builderConfig.detailSampleMaxError = (float) (1.0 / CELL_HEIGHT);
        RecastBuilder builder = new RecastBuilder();
        Heightfield heightfield = builder.buildHeightfield(meshes, builderConfig
    }
}