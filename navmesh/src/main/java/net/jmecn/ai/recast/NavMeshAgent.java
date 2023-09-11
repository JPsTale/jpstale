package net.jmecn.ai.recast;

import org.recast4j.detour.NavMesh;
import org.recast4j.detour.NavMeshQuery;
import org.recast4j.detour.NavMeshQueryResult;
import org.recast4j.detour.QueryFilter;
import org.recast4j.detour.RaycastHit;
import org.recast4j.detour.Result;
import org.recast4j.detour.Status;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.VertexBuffer;
import com.jme3.util.BufferUtils;
import java.util.List;

public class NavMeshAgent extends Node {

  private NavMeshQuery navMeshQuery;
  private QueryFilter queryFilter;
  private NavMesh navMesh;

  public NavMeshAgent(NavMesh navMesh, NavMeshQuery navMeshQuery, QueryFilter queryFilter) {
    this.navMesh = navMesh;
    this.navMeshQuery = navMeshQuery;
    this.queryFilter = queryFilter;
  }

  public Vector3f findPath(Vector3f source, Vector3f target) {
    int startRef = navMeshQuery.findNearestPoly(source.toArray(null), new float[3], queryFilter).getNearestRef();
    int endRef = navMeshQuery.findNearestPoly(target.toArray(null), new float[3], queryFilter).getNearestRef();

    Result<List<Long>> result = navMeshQuery.findPath(startRef, endRef, source.toArray(null), target.toArray(null), queryFilter);
    if (result.status == Status.SUCCSESS) {
      // 获取路径点
      List<Long> path = result.result;
      Vector3f[] waypoints = new Vector3f[path.size()];
      for (int i = 0; i < path.size(); i++) {
        float[] pos = navMesh.getPolyCenter(path.get(i).intValue());
        waypoints[i] = new Vector3f(pos[0], pos[1], pos[2]);
      }
      return waypoints[waypoints.length - 1];
    } else {
      // 寻路失败
      return null;
    }
  }

  public Vector3f raycast(Vector3f origin, Vector3f direction, float maxDistance) {
    float[] raycastOrigin = origin.toArray(null);
    float[] raycastDir = direction.toArray(null);
    RaycastHit hit = navMeshQuery.raycast(raycastOrigin, raycastDir, maxDistance, queryFilter);
    if (hit.hit) {
      return new Vector3f(hit.hitPos[0], hit.hitPos[1], hit.hitPos[2]);
    } else {
      return null;
    }
  }

  // 其他寻路相关方法和行为逻辑

}