package pqt.dss.disposal.model.vo;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;

import pqt.dss.disposal.model.vo.common.DssDisposalNoteHeaderView;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Nov 01 21:34:26 PKT 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DssDisposalNoteHeaderViewImpl extends ViewObjectImpl implements DssDisposalNoteHeaderView {
    /**
     * This is the default constructor (do not remove).
     */
    public DssDisposalNoteHeaderViewImpl() {
    }

    /**
     * Returns the variable value for VC_Recomm_By.
     * @return variable value for VC_Recomm_By
     */
    public String getVC_Recomm_By() {
        return (String) ensureVariableManager().getVariableValue("VC_Recomm_By");
    }

    /**
     * Sets <code>value</code> for variable VC_Recomm_By.
     * @param value value to bind as VC_Recomm_By
     */
    public void setVC_Recomm_By(String value) {
        ensureVariableManager().setVariableValue("VC_Recomm_By", value);
    }

    /**
     * Returns the variable value for VC_Sold_Contct_No.
     * @return variable value for VC_Sold_Contct_No
     */
    public String getVC_Sold_Contct_No() {
        return (String) ensureVariableManager().getVariableValue("VC_Sold_Contct_No");
    }

    /**
     * Sets <code>value</code> for variable VC_Sold_Contct_No.
     * @param value value to bind as VC_Sold_Contct_No
     */
    public void setVC_Sold_Contct_No(String value) {
        ensureVariableManager().setVariableValue("VC_Sold_Contct_No", value);
    }

    /**
     * Returns the variable value for NVC_wfDocumentId.
     * @return variable value for NVC_wfDocumentId
     */
    public Number getNVC_wfDocumentId() {
        return (Number) ensureVariableManager().getVariableValue("NVC_wfDocumentId");
    }

    /**
     * Sets <code>value</code> for variable NVC_wfDocumentId.
     * @param value value to bind as NVC_wfDocumentId
     */
    public void setNVC_wfDocumentId(Number value) {
        ensureVariableManager().setVariableValue("NVC_wfDocumentId", value);
        this.exeViewCrieteria(value);
    }
    public void exeViewCrieteria(Number val) {
            ViewObject vo = this.getViewObject();
            ViewCriteria vc = this.getViewCriteria("NotificationViewCriteria");
            vo.applyViewCriteria(vc);
            vo.setNamedWhereClauseParam("NVC_wfDocumentId", val);
            vo.executeQuery();
        }

    /**
     * Returns the variable value for VC_Doc_No.
     * @return variable value for VC_Doc_No
     */
    public String getVC_Doc_No() {
        return (String) ensureVariableManager().getVariableValue("VC_Doc_No");
    }

    /**
     * Sets <code>value</code> for variable VC_Doc_No.
     * @param value value to bind as VC_Doc_No
     */
    public void setVC_Doc_No(String value) {
        ensureVariableManager().setVariableValue("VC_Doc_No", value);
    }

    public void disposalNoteSearchUser()
    {
              ViewCriteria vc = this.getViewCriteria("DssDisposalNoteHeaderViewCriteria");
              this.applyViewCriteria(vc);
        
              setWhereClause(null);
              FacesContext fctx = FacesContext.getCurrentInstance();
              ExternalContext ectx = fctx.getExternalContext();
              HttpSession userSession = (HttpSession) ectx.getSession(false);
//              userSession.setAttribute("SSV_UserType","AGENT");
//              userSession.setAttribute("SSV_UserDept", 3);
//              userSession.setAttribute("pUserId",1139);
              Object VUserID = userSession.getAttribute("pUserId") == null ? "0" : userSession.getAttribute("pUserId");
         
              if (userSession.getAttribute("SSV_UserType").equals("BO")) {
                  setWhereClause("((exists (select 1 FROM DSS_SM_USERS AA, PQT_IL_LOC_BRANCH_DTL BD " + " WHERE 1=1" +
                                 " AND AA.USER_ID_PK  =" + VUserID +
                                 " AND AA.GIS_LOCATION_ID_FK = BD.IL_LOC_ID_FK " +
                                 " AND BD.BRANCH_CODE = QRSLT.BRANCH_CODE_FK)))");
              }
              //              setWhereClause("exists\n" + 
//              " (select 1 \n" + 
//              "          from dss_sm_user_branch a\n" + 
//              "         where a.user_id_fk = "+ VUserID+"\n" + 
//              "           and a.branch_code = BRANCH_CODE_FK)");
    //              setWhereClause("USER_ID_FK =" + VUserID);
              executeQuery();
          }

}

