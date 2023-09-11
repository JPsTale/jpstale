package net.jmecn.ai.recast;

import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer;
import com.jme3.util.BufferUtils;
import org.recast4j.detour.MeshData;
import org.recast4j.detour.Poly;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class PolyMeshWrapper extends Mesh {

    public PolyMeshWrapper(MeshData meshData) {
        setMode(Mode.Triangles);

        FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(meshData.verts.length / 3);
        verticesBuffer.put(meshData.verts);
        verticesBuffer.flip();
        setBuffer(VertexBuffer.Type.Position, 3, verticesBuffer);

        IntBuffer indicesBuffer = BufferUtils.createIntBuffer(meshData.polys.length * 3);
        for (Poly poly : meshData.polys) {
            int[] indices = poly.indices;
            indicesBuffer.put(indices[0]);
            indicesBuffer.put(indices[1]);
            indicesBuffer.put(indices[2]);
        }
        indicesBuffer.flip();
        setBuffer(VertexBuffer.Type.Index, 3, indicesBuffer);
    }
}