package observer.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationConfig;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
@RequiredArgsConstructor
public class FtpService {

    private final ApplicationConfig applicationConfig;

    @Async
    public void uploadFile(InputStream inputStream) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(applicationConfig.getFtpHostname());
            ftpClient.login(applicationConfig.getFtpUsername(), applicationConfig.getFtpPassword());
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.storeFile(applicationConfig.getFtpFilepath(), inputStream);
            inputStream.close();
            ftpClient.logout();
            log.info("File uploaded to ftp server");
        } catch (Exception e) {
            log.error("Error uploading file to ftp server", e);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                log.error("Error disconnecting client", e);
            }
        }
    }
}
