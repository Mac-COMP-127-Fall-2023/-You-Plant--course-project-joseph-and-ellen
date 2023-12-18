import edu.macalester.graphics.Image;



public class TallMeadowRue extends Critter {
    Image tallMeadowRue_stage1;
    Image tallMeadowRue_stage2;
    Image tallMeadowRue_stage3;


    
    protected void buildGraphics() {
        Image tallMeadowRue_stage1 = new Image(0, 0, "tallmeadowrue_stage1.png");
        getGraphics().add(tallMeadowRue_stage1);
       
    }
    void stage2() {
        Image tallMeadowRue_stage2 = new Image(0,0,"tallmeadowrue_stage2.png");
        getGraphics().remove(tallMeadowRue_stage1);
        getGraphics().add(tallMeadowRue_stage2);
    }
    void stage3() {
        Image tallMeadowRue_stage3 = new Image(0,0,"tallmeadowrue_stage3.png");
        getGraphics().remove(tallMeadowRue_stage2);
        getGraphics().add(tallMeadowRue_stage3);
    }
  
}















