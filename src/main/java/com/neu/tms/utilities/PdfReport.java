package com.neu.tms.utilities;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.neu.tms.configurations.TaskSeverity;
import com.neu.tms.configurations.TaskStatus;
import com.neu.tms.model.Task;

public class PdfReport extends AbstractPdfView{
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model,Document pdfdoc, PdfWriter pdfwriter,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Task task = (Task)model.get("task");
		//model was added to the scope by the Controller
		String name = task.getName();
		String description = task.getDescription();
		String project = task.getProject().getName();
		String taskSeverity = task.getTaskSeverity();
		String taskStatus = task.getTaskStatus();
		String assignedTo = task.getAssignedTo().getEmailId();
		String createdBy = task.getCreatedBy().getEmailId();
		pdfdoc.add(new Paragraph("Task Name: " + name + "\n " +"Description:"+description+"\n " +"Project Name:"+project+"\n " +"Task Severity:"+taskSeverity+"\n " +"Created By:"+createdBy+"\n " +"Assigned To:"+assignedTo));
	}

}
