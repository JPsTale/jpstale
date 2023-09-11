package net.jmecn.ai.recast;

import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer;
import org.recast4j.recast.geom.TriMesh;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Jme3ToRecast4jConverter {

    public static TriMesh convertMeshToGeometry(Mesh mesh) {
        float[] vertices = extractVertices(mesh);
        int[] triangles = extractTriangles(mesh);

        return new TriMesh(vertices, triangles);
    }

    private static float[] extractVertices(Mesh mesh) {
        VertexBuffer positionBuffer = mesh.getBuffer(VertexBuffer.Type.Position);
        FloatBuffer fb = (FloatBuffer) positionBuffer.getData();

        float[] positions = new float[positionBuffer.getNumElements() * 3];
        fb.get(positions);
        return positions;
    }

    private static int[] extractTriangles(Mesh mesh) {
        VertexBuffer indexBuffer = mesh.getBuffer(VertexBuffer.Type.Index);
        IntBuffer ib = (IntBuffer) indexBuffer.getData();
        int[] indices = new int[indexBuffer.getNumElements()];
        ib.get(indices);
        return indices;
    }
}