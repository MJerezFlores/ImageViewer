
package control;

import java.awt.event.ActionEvent;
import UI.ImageViewer;


public class PrevImageOperation implements Command{
    private final ImageViewer viewer;

    public PrevImageOperation(ImageViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public void execute() {
        this.viewer.setImage(this.viewer.getImage().getprevImage());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}
