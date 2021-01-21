package file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/upload.do")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		String user = request.getParameter("writer");
		String root = "c:\\fileupload\\" + user;
		File userRoot = new File(root);
		if(!userRoot.exists()) {
			userRoot.mkdirs();//userRoot가 없을 경우 해당 경로까지 폴더를 생성 해준다.
		}
//		File filePath = new File(
//				);
//		System.out.println(filePath.toURI());
//		System.out.println(filePath.getAbsolutePath());
//		
//		if(!filePath.exists()) {
//			filePath.mkdirs();//해당경로까지 모든 폴더를 다 만들어줌
//		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(userRoot);//업로드될 폴더
		factory.setSizeThreshold(1024 * 1024);//1mb -> 버퍼 메모리
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(int i=0;i<list.size();i++) {
				FileItem item = list.get(i);
				if(item.isFormField()) {
					//받은 내용중에 파일이 아닌 경우
					System.out.println(item.getFieldName() + " : " + item.getString(encoding));
				}else {
					//받은 내용중에 파일인 경우
					System.out.println("매개변수 명 : "+item.getFieldName());
					System.out.println("파일명 : "+item.getName());
					System.out.println("파일크기 : "+item.getSize());
					System.out.println("파일타입 : "+item.getContentType());
					if(item.getSize() > 0) {
						int idx = item.getName().lastIndexOf("\\");
						if(idx==-1)
							idx = item.getName().lastIndexOf("/");
						String fileName = item.getName().substring(idx+1);
						File uploadFile = new File(userRoot .getAbsolutePath()+ "\\" + fileName);
						System.out.println("셋팅된 전체 경로 : "+uploadFile);
						item.write(uploadFile);
//						request.setAttribute("file"+i, request.getContextPath() + "/upload/"+fileName);
						request.setAttribute("fileName"+i, fileName); 
//						String root = request.getSession().getServletContext().getRealPath("/")+"/upload/";
//						String name = fileName;
//						FileDTO dto = new FileDTO(new File(root + "\\" + name));
//						request.setAttribute("dto"+i, dto);
					}
					
				}
			}
			request.setAttribute("user",user); 
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("file_result.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

