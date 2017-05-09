package pseminarinformatik.gymnasiumeschenbach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity
{
    private PDFView pdfView;
    private PDFDownloader pdfDownloader;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //not working yet
        pdfDownloader = new PDFDownloader("192.168.1.115", 21, "Test", "test");
        pdfDownloader.execute("");

        pdfView = (PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("sample.pdf").load();
    }
}
