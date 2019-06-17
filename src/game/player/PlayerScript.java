package game.player;

import engine.Draw;
import engine.Game;
import engine.mapping.Map;
import engine.objects.GameObject;
import engine.Time;
import engine.input.KeyboardInput;
import engine.input.MouseInput;
import engine.math.Vector2;
import engine.scenes.SceneManager;
import engine.scripts.Animator;
import engine.scripts.Script;
import engine.scripts.SpriteRenderer;
import game.enemies.Enemy;
import game.worldobjects.Chest;
import game.worldobjects.ChestScript;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class PlayerScript extends Script {

    private ArrayList<Animator> animators = new ArrayList<>();

    private Animator leftHand, rightHand, torso, pants, head;

    private Player player;

    private boolean hasAttacked = false;

    private boolean oo = false;
    private boolean o = true;

    public PlayerScript(Animator leftHand, Animator rightHand, Animator torso, Animator pants, Animator head) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.torso = torso;
        this.pants = pants;
        this.head = head;
    }

    @Override
    public void load() {
        player = ((PlayerObject) parent).player;
        for (Script script : parent.getScripts()) {
            if (script instanceof Animator) {
                animators.add((Animator) script);
            } else if (script instanceof SpriteRenderer) {
                ((SpriteRenderer) script).setOffset(new Vector2(-32, -32));
            }
        }

        itemsChanged();

        player.setOnDeath(() -> {
            for (Animator animator : animators) {
                animator.setState(20);
                animator.setCurrent(0);
                animator.setLoop(false);
            }
        });
    }

    @Override
    public void update() {
        // Sync animators
        for (Animator animator : animators) {
            animator.setCurrent(animators.get(0).getCurrent());
        }

        if (player.getHealth() > 0 && o) {
            // Direction
            int ang = (int) (Math.toDegrees(Math.atan2(((Game.getHeight() / 2) - MouseInput.y), (Game.getWidth() / 2 - MouseInput.x)))) + 180;
            int dir;
            if ((ang >= 225 && ang <= 315)) dir = 0;
            else if ((ang >= 135 && ang <= 225)) dir = 1;
            else if ((ang >= 45 && ang <= 135)) dir = 2;
            else dir = 3;

            // Attacking
            boolean attacking = MouseInput.isPressed;
            if (attacking) {
                int state = 12;

                if (player.getRightHand() != null) switch (player.getRightHand().attackType) {
                    case RANGED:
                        state = 16;
                        break;
                    case MAGIC:
                        state = 12;
                        break;
                    case POKE:
                        state = 4;
                        break;
                    case SLASH:
                        state = 12;
                        break;
                }

                for (Animator animator : animators) {
                    animator.setState(state + dir);
                }
                // Hurting

                if (player.getRightHand() != null) switch (player.getRightHand().attackType) {
                    case RANGED:
                        if (animators.get(0).getCurrent() == 7 && !hasAttacked) {
                            for (GameObject object : SceneManager.getCurrentGameScene().getActive()) {
                                if (object instanceof Enemy) {
                                    Enemy enemy = (Enemy) object;
                                    double hyp1 = Math.hypot(parent.x - enemy.x, parent.y - enemy.y);
                                    double hyp2 = MouseInput.getWorldLoc().subtract(enemy.x + 32, enemy.y + 32).hypot();

                                    Draw.drawText(hyp1 + "/" + hyp2, 0, 50, true);

                                    if (hyp1 < 100 && hyp2 < 32) {
                                        enemy.damage(50); // Damage
                                        hasAttacked = true;
                                    }
                                }
                            }
                        } else if (animators.get(0).getCurrent() != 7){
                            hasAttacked = false;
                        }
                        break;
                    case MAGIC:
                        state = 12;
                        break;
                    case POKE:
                        if (animators.get(0).getCurrent() == 6 && !hasAttacked) {
                            for (GameObject object : SceneManager.getCurrentGameScene().getActive()) {
                                if (object instanceof Enemy) {
                                    Enemy enemy = (Enemy) object;
                                    double hyp1 = Math.hypot(parent.x - enemy.x, parent.y - enemy.y);
                                    double hyp2 = MouseInput.getWorldLoc().subtract(enemy.x + 32, enemy.y + 32).hypot();

                                    Draw.drawText(hyp1 + "/" + hyp2, 0, 50, true);

                                    if (hyp1 < 32 && hyp2 < 32) {
                                        enemy.damage(25); // Damage
                                        hasAttacked = true;
                                    }
                                }
                            }
                        } else if (animators.get(0).getCurrent() != 6){
                            hasAttacked = false;
                        }
                        break;
                    case SLASH:
                        if (animators.get(0).getCurrent() == 4 && !hasAttacked) {
                            for (GameObject object : SceneManager.getCurrentGameScene().getActive()) {
                                if (object instanceof Enemy) {
                                    Enemy enemy = (Enemy) object;
                                    double hyp1 = Math.hypot(parent.x - enemy.x, parent.y - enemy.y);

                                    if (hyp1 < 32) {
                                        enemy.damage(25); // Damage
                                        hasAttacked = true;
                                    }
                                }
                            }
                        } else if (animators.get(0).getCurrent() != 4){
                            hasAttacked = false;
                        }
                        break;
                }
            }
            Vector2 dVector = new Vector2(parent.x, parent.y);
            // Movement
            boolean moving = false;
            if (KeyboardInput.isKeyDown(KeyCode.W) && !attacking) {
                for (Animator animator : animators) {
                    animator.setState(8);
                }
                dVector.y -= 200 * Time.deltaTime;
                moving = true;
            }
            if (KeyboardInput.isKeyDown(KeyCode.S) && !attacking) {
                for (Animator animator : animators) {
                    animator.setState(10);
                }
                dVector.y += 200 * Time.deltaTime;
                moving = true;
            }
            if (KeyboardInput.isKeyDown(KeyCode.A) && !attacking) {
                for (Animator animator : animators) {
                    animator.setState(9);
                }
                dVector.x -= 200 * Time.deltaTime;
                moving = true;
            }
            if (KeyboardInput.isKeyDown(KeyCode.D) && !attacking) {
                for (Animator animator : animators) {
                    animator.setState(11);
                }
                dVector.x += 200 * Time.deltaTime;
                moving = true;
            }
            boolean movable = true;
            for (Map map: SceneManager.getCurrentGameScene().getMaps()){
                int[] coords = map.getCollidedTile(dVector);
                if (!map.getTile(coords[0], coords[1]).getTraversable()) {
                    movable = false;
                }
            }
            if (movable){
                parent.x = dVector.x;
                parent.y = dVector.y;
            }

            // Static looking direction
            if (!(moving || attacking)) {
                for (Animator animator : animators) {
                    animator.setState(21 + dir);
                }
            }
        } else if (!o) {
            for (Animator animator : animators) {
                animator.setState(21+2);
            }
        }

        if (KeyboardInput.isKeyDown(KeyCode.E) && !oo) {
            for (GameObject object : SceneManager.getCurrentGameScene().getActive()) {
                if (object instanceof Chest) {
                    for (Script script : object.getScripts()) {
                        if (script instanceof ChestScript) {
                            if (o) ((ChestScript) script).open((PlayerObject) parent);
                            else ((ChestScript) script).close();
                        }
                    }
                }
            }
            o = !o;
            oo = true;
        } else if (!KeyboardInput.isKeyDown(KeyCode.E)) {
            oo = false;
        }

        SceneManager.getCurrentGameScene().cameraPosition = new Vector2(parent.x-(Game.getWidth()/2), parent.y-(Game.getHeight()/2));
    }

    public void itemsChanged() {
        if (player.getRightHand() == null) rightHand.setImages(null);
        else rightHand.setImages(player.getRightHand().getImageSet(player.getGender()));
        if (player.getChestPlate() == null) {
            if (player.getTorso() == null) torso.setImages(null);
            else torso.setImages(player.getTorso().getSet(player.getGender()));
        } else torso.setImages(player.getChestPlate().getSet(player.getGender()));
        if (player.getLeggings() == null) {
            if (player.getPants() == null) pants.setImages(null);
            else pants.setImages(player.getPants().getSet(player.getGender()));
        } else pants.setImages(player.getLeggings().getSet(player.getGender()));
        if (player.getHelmet() == null) {
            if (player.getHead() == null) {
                if (player.getHairType() == null) head.setImages(null);
                else head.setImages(player.getHairType().getSet(player.getHairColor()));
            } else head.setImages(player.getHead().getSet(player.getGender()));
        } else head.setImages(player.getHelmet().getSet(player.getGender()));
    }

    @Override
    public void render() {
        //Draw.drawText(MouseInput.getWorldLoc().x + "/" + MouseInput.getWorldLoc().y + "", 0, 20, true);
        Draw.drawText(parent.x + "/" + parent.y, 0, 20, true);
    }

}
