package cilicili.jz2.controller;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Map;

public interface IUploadController {
	Map<String, Serializable> upload(MultipartFile file, String token);
}
