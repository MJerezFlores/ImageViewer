
package imageviewer;

import control.Command;
import control.NextImageOperation;
import control.PrevImageOperation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Image;
import persistence.ImageSetLoader;
import swing.ActionListenerFactory;
import swing.ApplicationFrame;


public class Application {
    
    public static void main(String[] args) {
        new Application().execute();
    }
    
    private String filename = "C:\\Users\\Public\\Pictures\\Sample Pictures";
    private Map<String, Command> commandMap;
    private ApplicationFrame applicationFrame;

    private void execute() {
        List<Image> list = new ImageSetLoader(filename).load();
        applicationFrame = createAplicationFrame();
        applicationFrame.getImageViewer().setImage(list.get(0));
        createCommands();
        applicationFrame.setVisible(true);    
    }

    private ApplicationFrame createAplicationFrame() {
        return new ApplicationFrame(new ActionListenerFactory(){

            @Override
            public ActionListener createActionListener(final String action) {
                return new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Command command = commandMap.get(action);
                        if (command == null) return;
                        command.execute();
            
                    }
                };
            }            
            
        });
    }

    private void createCommands() {
        commandMap = new HashMap<>();
        commandMap.put("Next", new NextImageOperation(applicationFrame.getImageViewer()));
        commandMap.put("Prev", new PrevImageOperation(applicationFrame.getImageViewer()));
    }    
   
}
