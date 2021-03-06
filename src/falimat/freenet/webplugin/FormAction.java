package falimat.freenet.webplugin;

import falimat.freenet.webplugin.components.Form;
import freenet.pluginmanager.HTTPRequest;

public abstract class FormAction extends SimpleAction {

    private Form form;
    
    private boolean validateBeforeExecution = true;

    public FormAction(Form form) {
        this.form = form;
    }

    public FormAction(Form form, boolean validateBeforeExecution) {
        this.form = form;
        this.validateBeforeExecution = validateBeforeExecution;   
    }

    @Override
    public void execute(HTTPRequest request) {
        boolean validationSuccesfull = validateBeforeExecution ? this.form.validate(request) : true;
        if (validationSuccesfull) {
            this.onSubmit(request);
        }
    }
    
    protected abstract void onSubmit(HTTPRequest request);
    
    protected abstract void onInvalidSubmission(HTTPRequest request);

}
