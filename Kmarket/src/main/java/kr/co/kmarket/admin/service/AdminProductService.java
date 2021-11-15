package kr.co.kmarket.admin.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kmarket.admin.dao.AdminProductDao;
import kr.co.kmarket.vo.ProductCate1Vo;
import kr.co.kmarket.vo.ProductCate2Vo;
import kr.co.kmarket.vo.ProductVo;

@Service
public class AdminProductService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminProductDao dao;
	
	public void insertProduct(ProductVo vo) {
		dao.insertProduct(vo);
	}
	public void selectProduct() {}
	public void selectProducts() {}
	public void updateProduct() {}
	public void deleteProduct() {}
	
	public List<ProductCate1Vo> selectCate1() {
		return dao.selectCate1();
	}
	
	public List<ProductCate2Vo> selectCate2(int cate1) {
		return dao.selectCate2(cate1);
	}
	



//파일 업로드
	public ProductVo fileUpload(ProductVo vo) {
		
		File file = new File("src/main/resources/static/thumb/");
	    String path = file.getAbsolutePath();

	    int i = 0;
	    
	    for(MultipartFile mf : vo.getFiles()) {
	    	
	    	if(!mf.isEmpty()) {
		    	// 썸네일 이미지 파일을 첨부했다면
	    	    String name = mf.getOriginalFilename();
	    	    String ext = name.substring(name.lastIndexOf("."));

	    	    /* 절대로 겹칠 수 없는 난수를 만들어서 중복 이름 파일들을 구분하여 준다*/
	    	    String uName = UUID.randomUUID().toString()+ext;
	    		String fullpath = path+"/"+vo.getCate1()+"/"+vo.getCate2()+"/";
	    		
    		 try{
    			 	logger.info("fileupload try1...");
    			 
    			 	// 디렉터리 생성
    			 	Path root = Paths.get(fullpath);
    			 	Files.createDirectories(root);
    			 			
    			 	logger.info("fileupload try2...");
    			 	
    		    	// 첨부파일 저장
    			    mf.transferTo(new File(fullpath+uName));
    			    logger.info("fileupload try3...");
    			    
    			    // 이미지 새이름으로 vo저장 
    			    if(i==0) vo.setThumb1(uName);
    			    if(i==1) vo.setThumb2(uName);
    			    if(i==2) vo.setThumb3(uName);
    			    if(i==3) vo.setDetail(uName);
    			    logger.info("fileupload try4...");
    			    
    		    }catch (Exception e) {
    				e.printStackTrace();
    				logger.error("fileupload error... : "+e.getMessage());
    			}
	    	    
	    	} // if end
	    	
	    	i++;
	    	
	    }// for end
	    
	    return vo;
	}// fileupload end
}