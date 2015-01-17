
package control;

import java.awt.event.ActionEvent;
import UI.ImageViewer;


public class NextImageOperation implements Command{
    private final ImageViewer viewer;

    public NextImageOperation(ImageViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public void execute() {
        this.viewer.setImage(this.viewer.getImage().getnextImage());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}
