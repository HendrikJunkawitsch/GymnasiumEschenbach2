package pseminarinformatik.gymnasiumeschenbach;

import android.os.AsyncTask;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class PDFDownloader extends AsyncTask<String, Void, String>
{
    private String serverIP;
    private int port;
    private String username;
    private String password;
    private FTPClient ftpClient;

    public PDFDownloader(String serverIP, int port, String username, String password)
    {
        this.serverIP = serverIP;
        this.port = port;
        this.username = username;
        this.password = password;

        ftpClient = new FTPClient();
    }

    protected String doInBackground(String... params)
    {
        try
        {
            ftpClient.connect(serverIP, port);
            ftpClient.login(username, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            String remoteFile1 = "/Test.txt";
            File downloadFile1 = new File("D:/Hendrik/Dokumente/FTP/Downloads/Test.txt");
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();
        }
        catch (IOException ex)
        {

        }
        finally
        {
            try
            {
                if (ftpClient.isConnected())
                {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            }
            catch (IOException ex)
            {

            }
        }
        return null;
    }

    protected void onPostExecute(String result)
    {

    }
}
