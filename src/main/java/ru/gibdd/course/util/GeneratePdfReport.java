package ru.gibdd.course.util;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.gibdd.course.pojo.PenaltyByDriverLicense;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GeneratePdfReport {

    private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);

    public static final String FONT = "c:/windows/fonts/times.ttf";

    public static ByteArrayInputStream penaltyByRiverLicenseReport(Iterable<PenaltyByDriverLicense> penaltys) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();




//        BaseFont times = BaseFont.createFont("c:/windows/fonts/times.ttf","cp1251",BaseFont.EMBEDDED);

        try {
            BaseFont bf= BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font=new Font(bf,14,Font.NORMAL);

            PdfPTable table = new PdfPTable(2);
//            table.setWidthPercentage(60);
//            table.setWidths(new int[]{1, 1});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

//            PdfPCell hcell;
//            hcell = new PdfPCell(new Phrase("decreeNumber", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);
//
//            hcell = new PdfPCell(new Phrase("Article", headFont));
//            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(hcell);

            for (PenaltyByDriverLicense penalty : penaltys) {

                PdfPCell cellPaid;

                cellPaid = new PdfPCell(new Phrase("Оплачено", font));
                cellPaid.setVerticalAlignment(Element.ALIGN_CENTER);
                cellPaid.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellPaid);

                if (penalty.isPaid()) {
                    cellPaid = new PdfPCell(new Phrase("Да",font));
                    cellPaid.setVerticalAlignment(Element.ALIGN_CENTER);
                    cellPaid.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cellPaid);

                    PdfPCell cellDatePaid;

                    cellDatePaid = new PdfPCell(new Phrase("Дата оплаты", font));
                    cellDatePaid.setVerticalAlignment(Element.ALIGN_CENTER);
                    cellDatePaid.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cellDatePaid);

                    cellDatePaid = new PdfPCell(new Phrase(penalty.getDate_time_payment().toString(), font));
                    cellDatePaid.setVerticalAlignment(Element.ALIGN_CENTER);
                    cellDatePaid.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cellDatePaid);
                }
                else {
                    cellPaid = new PdfPCell(new Phrase("Нет", font));
                    cellPaid.setVerticalAlignment(Element.ALIGN_CENTER);
                    cellPaid.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cellPaid);
                }

                PdfPCell cellDatePenalty;
                cellDatePenalty = new PdfPCell(new Phrase("Дата нарушения", font));
                cellDatePenalty.setVerticalAlignment(Element.ALIGN_CENTER);
                cellDatePenalty.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellDatePenalty);

                cellDatePenalty = new PdfPCell(new Phrase(penalty.getDate_time_penalty().toString(), font));
                cellDatePenalty.setVerticalAlignment(Element.ALIGN_CENTER);
                cellDatePenalty.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellDatePenalty);

                PdfPCell cellPlaceOfViolation;

                cellPlaceOfViolation = new PdfPCell(new Phrase("Место нарушения", font));
                cellPlaceOfViolation.setVerticalAlignment(Element.ALIGN_CENTER);
                cellPlaceOfViolation.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellPlaceOfViolation);

                cellPlaceOfViolation = new PdfPCell(new Phrase(penalty.getPlace_of_violation(), font));
                cellPlaceOfViolation.setVerticalAlignment(Element.ALIGN_CENTER);
                cellPlaceOfViolation.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellPlaceOfViolation);

                PdfPCell cellPenaltySize;

                cellPenaltySize = new PdfPCell(new Phrase("Размер штрафа", font));
                cellPenaltySize.setVerticalAlignment(Element.ALIGN_CENTER);
                cellPenaltySize.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellPenaltySize);

//                int penaltySize = Integer.parseInt(penalty.getPenalty_size());
                cellPenaltySize = new PdfPCell(new Phrase(String.valueOf(penalty.getPenalty_size()), font));
                cellPenaltySize.setVerticalAlignment(Element.ALIGN_CENTER);
                cellPenaltySize.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellPenaltySize);

                PdfPCell cellArticle;

                cellArticle = new PdfPCell(new Phrase("Статья", font));
                cellArticle.setVerticalAlignment(Element.ALIGN_CENTER);
                cellArticle.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellArticle);

                cellArticle = new PdfPCell(new Phrase(penalty.getArticle(), font));
                cellArticle.setVerticalAlignment(Element.ALIGN_CENTER);
                cellArticle.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellArticle);

                PdfPCell cellShortDescription;

                cellShortDescription = new PdfPCell(new Phrase("Описание", font));
                cellShortDescription.setVerticalAlignment(Element.ALIGN_CENTER);
                cellShortDescription.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellShortDescription);

                cellShortDescription = new PdfPCell(new Phrase(penalty.getShort_description(), font));
                cellShortDescription.setVerticalAlignment(Element.ALIGN_CENTER);
                cellShortDescription.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellShortDescription);

                PdfPCell cellDecreeNumber;

                cellDecreeNumber = new PdfPCell(new Phrase("Номер постановления", font));
                cellDecreeNumber.setVerticalAlignment(Element.ALIGN_CENTER);
                cellDecreeNumber.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellDecreeNumber);

                cellDecreeNumber = new PdfPCell(new Phrase(penalty.getDecreeNumber(), font));
                cellDecreeNumber.setVerticalAlignment(Element.ALIGN_CENTER);
                cellDecreeNumber.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cellDecreeNumber);

            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);

            document.close();

        } catch (DocumentException | IOException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}