package DoublePendulum;

import java.util.*;

//Takes input from View and filters it to Model.
public class DoublePendulumControl {
    DoublePendulumModel model;
    DoublePendulumView view;


    ArrayList<PendulumBuilder> pendulumsInfo;

    public DoublePendulumControl(DoublePendulumModel model, DoublePendulumView view) {
        this.model = model;
        this.view = view;
        this.pendulumsInfo = new ArrayList<PendulumBuilder>();
    }

    public void addPendulumInfo() {
        pendulumsInfo.add(new PendulumBuilder());
    }
    //Will be used to update the pendulum info with each change to the text fields in a Pendulum Menu
    public void setPendulumInfo(int index, String property,String value) {

    }
    //Will be used later once I figure out how to return functions
    //public (Function) getSetterFromProperty(String property)





}
