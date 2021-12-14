package dsw.gerudok.app.gui.swing.controller;

import com.sun.tools.javac.Main;
import dsw.gerudok.app.AppCore;
import dsw.gerudok.app.gui.swing.error.ErrorType;
import dsw.gerudok.app.gui.swing.view.MainFrame;
import dsw.gerudok.app.repository.Page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class PaintRectangleAction extends AbstractRudokAction{

    public PaintRectangleAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/rectangle.png"));
        putValue(SHORT_DESCRIPTION, "Rectangle");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getTree().getSelectedNode().getNodeModel() instanceof Page){
            Page page = (Page) MainFrame.getInstance().getTree().getSelectedNode().getNodeModel();
            page.startRectangleState();
        }
        else{
            AppCore.getInstance().getErrorHandler().napraviGresku(ErrorType.NESELEKTOVAN_PAGE);
            return;
        }



    }
}
