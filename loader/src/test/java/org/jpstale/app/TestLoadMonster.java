package org.jpstale.app;

import org.jpstale.assets.AssetFactory;
import org.jpstale.assets.plugins.ase.AseKey;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.Skeleton;
import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResults;
import com.jme3.font.BitmapText;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.material.MatParam;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.debug.Arrow;
import com.jme3.scene.debug.Grid;
import com.jme3.scene.debug.SkeletonDebugger;
import com.jme3.system.AppSettings;
import org.jpstale.assets.plugins.smd.SmdKey;
import org.jpstale.assets.utils.ModelBuilder;
import org.jpstale.constants.SceneConstants;

public class TestLoadMonster extends TestBase {

	public static void main(String[] args) {
		TestLoadMonster a = new TestLoadMonster();
		a.start();
	}

	/** Declaring the "Shoot" action and mapping to its triggers. */
	private void initKeys() {
		inputManager.addMapping("Shoot", new MouseButtonTrigger(
				MouseInput.BUTTON_LEFT)); // trigger 2:
		inputManager.addListener(actionListener, "Shoot");
	}

	/** Defining the "Shoot" action: Determine what was hit and how to respond. */
	private ActionListener actionListener = new ActionListener() {

		public void onAction(String name, boolean keyPressed, float tpf) {
			if (name.equals("Shoot") && !keyPressed) {
				// 1. Reset results list.
				CollisionResults results = new CollisionResults();
				// 2. Aim the ray from cam loc to cam direction.
				Ray ray = new Ray(cam.getLocation(), cam.getDirection());
				// 3. Collect intersections between Ray and Shootables in
				// results list.
				rootNode.collideWith(ray, results);
				// 4. Print the results
				if (results.size() > 0) {
					Geometry geom = results.getCollision(0).getGeometry();
					
					// Print name & mat
					System.out.println(geom.getName());
					Material mat = geom.getMaterial();
					MatParam param = mat.getParam("DiffuseMap");
					System.out.println(param);
				}
			}
		}
	};

	/** A centred plus sign to help the player aim. */
	protected void initCrossHairs() {
		setDisplayStatView(false);
		guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
		BitmapText ch = new BitmapText(guiFont, false);
		ch.setSize(guiFont.getCharSet().getRenderedSize() * 2);
		ch.setText("+"); // crosshairs
		ch.setLocalTranslation(
				// center
				(float) settings.getWidth() / 2 - ch.getLineWidth() / 2,
				(float) settings.getHeight() / 2 + ch.getLineHeight() / 2, 0);
		guiNode.attachChild(ch);
	}

	@Override
	public void init() {
		this.setPauseOnLostFocus(false);

		cam.setLocation(new Vector3f(10, 8, 10));
		cam.lookAt(Vector3f.ZERO, cam.getUp());
		this.flyCam.setMoveSpeed(10f);

		AssetFactory.setAssetManager(assetManager);


		Spatial flag = AssetFactory.loadFlag();
		flag.scale(SceneConstants.scale);
		rootNode.attachChild(flag);

		Spatial death_knight = AssetFactory.loadCharacter("char/monster/death_knight/death_knight.ASE");
		death_knight.move(4, 0, 0);
		death_knight.scale(SceneConstants.scale);
		rootNode.attachChild(death_knight);

		Spatial chaoscara = AssetFactory.loadCharacter("char/monster/chaoscara/chaoscara.ASE");
		chaoscara.move(2, 0, 0);
		chaoscara.scale(SceneConstants.scale);
		rootNode.attachChild(chaoscara);
		
//		debugSke(death_knight);
//		debugSke(chaoscara);

		initAmbient();
		initKeys();
		initCrossHairs();

		viewPort.setBackgroundColor(ColorRGBA.LightGray);

	}

	private void initAmbient() {
		AmbientLight light = new AmbientLight();
		light.setColor(ColorRGBA.White);
		rootNode.addLight(light);
	}

	public void debugSke(Spatial model) {
		final AnimControl ac = findAnimControl(model);

		try {
			// add a skeleton debugger to make bones visible
			final Skeleton skel = ac.getSkeleton();
			final SkeletonDebugger skeletonDebug = new SkeletonDebugger(
					"skeleton", skel);
			final Material mat = new Material(assetManager,
					"Common/MatDefs/Misc/Unshaded.j3md");
			mat.setColor("Color", ColorRGBA.Green);
			mat.getAdditionalRenderState().setDepthTest(false);
			skeletonDebug.setMaterial(mat);
			((Node) ac.getSpatial()).attachChild(skeletonDebug);

			// create a channel and start the walk animation
			final AnimChannel channel = ac.createChannel();
			channel.setAnim("Anim");
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to find the animation control, because it is not on the models
	 * root node.
	 * 
	 * @param parent
	 *            The spatial to search.
	 * @return The {@link AnimControl} or null if it does not exist.
	 */
	public AnimControl findAnimControl(final Spatial parent) {
		final AnimControl animControl = parent.getControl(AnimControl.class);
		if (animControl != null) {
			return animControl;
		}

		if (parent instanceof Node) {
			for (final Spatial s : ((Node) parent).getChildren()) {
				final AnimControl animControl2 = findAnimControl(s);
				if (animControl2 != null) {
					return animControl2;
				}
			}
		}

		return null;
	}
}
