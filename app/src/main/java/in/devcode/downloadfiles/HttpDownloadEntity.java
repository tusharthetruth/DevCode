package in.devcode.downloadfiles;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpDownloadEntity {
    private static final int BUFFER_SIZE = 4096;

    /**
     * Downloads a file from a URL
     *
     * @param fileURL HTTP URL of the file to be downloaded
     * @param saveDir path of the directory to save the file
     * @throws IOException
     */
    public static String downloadFile(String fileURL, String saveDir)
            throws IOException {
        String filePath = "";
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();

            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }

            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);

            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
            File f = new File(saveFilePath);
            if (!f.exists())
                f.createNewFile();
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            System.out.println("File downloaded");
            filePath = saveFilePath;
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
        return filePath;
    }

    public void downloadWithownName(String urlName) {
        int count;
        try {
            File myDirectory = new File(Environment.getExternalStorageDirectory(), "AppName");
            if (!myDirectory.exists())
                myDirectory.mkdir();
            File nomedia = new File(myDirectory.getPath(), ".nomedia");
            if (!nomedia.exists())
                nomedia.mkdir();
            File f = new File(nomedia.getPath(), "imageName.jpg");
            if (!f.exists())
                f.createNewFile();
            System.out.println("Downloading");
            URL url = new URL(urlName);
            URLConnection conection = url.openConnection();
            conection.connect();
            int lenghtOfFile = conection.getContentLength();
            InputStream input = new BufferedInputStream(url.openStream(), 8192);
            // Output stream to write file
            OutputStream output = new FileOutputStream(f);
            byte data[] = new byte[1024];
            long total = 0;
            while ((count = input.read(data)) != -1) {
                total += count;
                // writing data to file
                output.write(data, 0, count);
            }
            // flushing output
            output.flush();
            // closing streams
            output.close();
            input.close();
            String filePath = Uri.fromFile(f).toString();

        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
        }
    }
}
