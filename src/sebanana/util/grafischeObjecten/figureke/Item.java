package sebanana.util.grafischeObjecten.figureke;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import sebanana.models.Modelverzameling;

/**
 *
 * @author Ellen
 */
public class Item  extends Figureke implements Spatiebaar{
   private static final String ITEM = "Item";
   private double height;
   private double width;
   private Shape shape;
   private String afbeelding;
   private Image image;
   private int id;
   private String color;
   private boolean eetbaar;
   private ContextMenu contextMenu;
   private ImageView miniminiImageView;
    private ImageView gewoonImageView;

   public Item() {
       super.setFill(Color.GREEN);
    }

   /*
    * voor tabel (mommenteel)
    */
    public String getAfbeelding() {
        return afbeelding;
    }

    public void setAfbeelding(String afbeelding) {
        this.afbeelding = afbeelding;
    }

    public Image getImage() {
        if(image == null){
            image = new Image(getImageLocation() + afbeelding);
        }
        return image;
    }

    
    
    /*
     * figuur
     */
    @Override
    public Node getNode() {
        if(getImage() != null){
            if (miniminiImageView == null){
                miniminiImageView = new ImageView(getImage());
                miniminiImageView.setFitHeight(height);
                miniminiImageView.setFitWidth(width);
                miniminiImageView.setTranslateX(getX());
                miniminiImageView.setTranslateY(getY());
            }
            return miniminiImageView;
        }else{
            return getShape();
        }
   }

    public ImageView getImageView() {
        if(gewoonImageView==null){
            gewoonImageView = new ImageView(getImage());
            //iv2.setFitHeight(50);
            //iv2.setFitWidth(30);
            gewoonImageView.setFitHeight(50);
            gewoonImageView.setFitWidth((getImage().getWidth()/5));
        }
        return gewoonImageView;
    }
    
    
    
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        setFill(Color.valueOf(color));
    }
    
   
   @Override
   public Shape getShape() {
        if(shape == null){
            shape = new Rectangle(getX(), getY(), width, height);
            shape.setFill(getFill());
        }
        return shape;
    }
    

    
   public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    
   @Override
    public String toString(){
        return getName() + id;
    }
   
   
   /*
    * id waaraan het item herkend kan worden
    * 
    */
    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

       
    public void setId(int id) {
        this.id = id;
    }
    
    
    /*
     * saai
     */
    public boolean isEetbaar(){
        return eetbaar;
    }
   
    @XmlElement (name = "eetbaar")
    public void setSaai(String eetbaar){
        this.eetbaar = Boolean.parseBoolean(eetbaar);
    }
    
    public String getSaai(){
        return Boolean.toString(eetbaar);
    }
    
    public void setSaai(boolean eetbaar){
       this.eetbaar=eetbaar;
    }
    
    /*
     * spatiebaar
     */
    public boolean erOp(double nx, double ny){
        if(getX()== nx
                    &&
               getY() == ny
                    ){
                return true;
            }
        return false;
    }

    @Override
    public boolean hasAction() {
        return true;
    }

    @Override
    public void doAction(Modelverzameling ab) {
        ab.getTekstVakModel().setText("je vond " + getName());
        if(!isEetbaar()){ doPersonageBeinvloeding(ab);}
        /*
         * verplaatsen
         */
        ab.getObjectenOpslag().verwijder(this);
        ab.getRugzak().add(this);
    }

    @Override
    public String watIsHet() {
        return ITEM;
    }
    
    
    public boolean hasKlik(){
        return true;
    }
    

    


    public ContextMenu getContextMenu(final Modelverzameling mv){
        if(contextMenu == null){
            contextMenu = new ContextMenu();
            MenuItem menuItem1 = new MenuItem("Wat is het");
            menuItem1.setOnAction(new EventHandler<ActionEvent>() {
                       @Override
                       public void handle(ActionEvent event) {
                           mv.getTekstVakModel().setText("Dit is een "+ getName());
                       }
                  }); 
            contextMenu.getItems().add(menuItem1);
        
            
            if(isEetbaar()){
                    MenuItem menuItem2 = new MenuItem("Eet");
                    menuItem2.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent event) {
                               eet(mv);
                           }
                      });   
                   contextMenu.getItems().add(menuItem2);
            }

        }
        return contextMenu;
        
    }
    
    private void eet(final Modelverzameling mv){
        doPersonageBeinvloeding(mv);
        mv.getTekstVakModel().setText("Je at een "+getName());
        mv.getRugzak().remove(this);        
    }
}
