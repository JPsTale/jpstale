package org.jpstale.assets.plugins.ase.mesh;

import org.jpstale.assets.plugins.ase.material.Mtl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AseScene implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4067953791617440270L;
	
	public String name;
	private int lastframe = 29;
	private float framespeed = 30;
	private float ticksPerFrame = 160;

	private HashMap<Integer, Mtl> mtlList = new HashMap<Integer, Mtl>();
	private List<GeomObject> objects = new ArrayList<GeomObject>();
	public boolean hasAnimation = false;

	public void add(Mtl mtl) {
		if (mtlList == null) {
			mtlList = new HashMap<Integer, Mtl>();
		}

		mtlList.put(mtl.id, mtl);
	}

	public void add(GeomObject obj) {
		if (objects == null) {
			objects = new ArrayList<GeomObject>();
		}
		objects.add(obj);
	}

	public int getLastframe() {
		return lastframe;
	}

	public void setLastframe(int lastframe) {
		this.lastframe = lastframe;
	}

	public float getFramespeed() {
		return framespeed;
	}

	public void setFramespeed(float framespeed) {
		this.framespeed = framespeed;
	}

	public float getTicksPerFrame() {
		return ticksPerFrame;
	}

	public void setTicksPerFrame(float ticksPerFrame) {
		this.ticksPerFrame = ticksPerFrame;
	}

	public float getSecsPerTick() {
		return 1.0f / (framespeed * ticksPerFrame);
	}
	
	public float getAnimationLength() {
		return (lastframe + 1) / framespeed;
	}

	public HashMap<Integer, Mtl> getMtlList() {
		return mtlList;
	}

	public List<GeomObject> getObjects() {
		return objects;
	}

	public Mtl getMtl(int id) {
		if (mtlList != null)
			return mtlList.get(id);
		return null;
	}

}
