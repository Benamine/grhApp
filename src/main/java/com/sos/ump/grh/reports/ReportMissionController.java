/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.grh.reports;

import com.sos.ump.grh.entities.Personne;
import fr.opensagres.xdocreport.core.document.DocumentKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.web.dispatcher.AbstractXDocReportWEBController;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mab.salhi
 */
public class ReportMissionController  extends
                AbstractXDocReportWEBController {

  public static final String REPORT_ID = "attestationMission.odt";

  public ReportMissionController() {
    super(TemplateEngineKind.Velocity, DocumentKind.ODT);
  }

  @Override
  public InputStream getSourceStream() {
    return ReportMissionController.class.getResourceAsStream("attestationMission.odt");
  }

  @Override
  protected FieldsMetadata createFieldsMetadata() {
    return null;
  }

  @Override
  public void populateContext(IContext context, IXDocReport report, HttpServletRequest request) {
    String nom = request.getParameter("dest");
    String prenom1 = request.getParameter("vil");
    String som = request.getParameter("pays");
    //String diplome = request.getParameter("diplome");
    //Long som = Long.parseLong(numSom);
    context.put("destination", nom);
    context.put("ville", prenom1);
    context.put("pays", som);
    
    //context.put("diplome", diplome);
  }
}