package pqt.dss.disposal.view;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class createUpdateBean {
    public createUpdateBean() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String b2_action() {
        BindingContainer bindings = getBindings();
                OperationBinding operationBinding = bindings.getOperationBinding("Apply");
                DCBindingContainer dcBindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding LineVO = (DCIteratorBinding) dcBindings.get("DssDisposalNoteView1Iterator");

                if (LineVO.getEstimatedRowCount() == 0) {
                    FacesMessage msg =
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                         "Please add below detail", "");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    operationBinding.execute();
                }
                //        Object result = operationBinding.execute();
                //        if (!operationBinding.getErrors().isEmpty()) {
                //            return null;
                //        }
                return null;
            }

}
