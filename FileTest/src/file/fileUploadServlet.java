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
 * Servlet implementation class fileUploadServlet
 */
@WebServlet("/upload.do")
public class fileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		File filePath = new File(request.getSession().getServletContext().getRealPath("/")+"/upload");
		System.out.println(filePath.getAbsolutePath());//file의 절대 경로
		System.out.println(filePath.toURI());//해당 경로
		
		if(!filePath.exists()) {//파일경로가 있는가?
			filePath.mkdirs();//해당경로까지 모든 폴더를 다 만들어줌
			
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(filePath);//업로드될 폴더
		factory.setSizeThreshold(1024*1024);//1024*1024 = 1MB
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> list = upload.parseRequest(request);//파일을 업로드 할때 폼으로 업로드할때
			for(int i=0; i<list.size();i++) {
				FileItem item = list.get(i);
				if(item.isFormField()){//얘가 파일인지 일반적 전송인지 판단
					System.out.println(item.getFieldName() + " : " + item.getString(encoding));
				}else {
					System.out.println("매개변수 명 : " + item.getFieldName());//올릴때 지정했던 name속성의 명
					System.out.println("파일명 : " + item.getName());//현재 올린 파일명
					System.out.println("파일 크기 : " + item.getSize());
					System.out.println("파일 타입 : " + item.getContentType());
					if(item.getSize()>0) {
						int idx = item.getName().lastIndexOf("\\");//마지막에 있는 위치를 찾는다
						if(idx == -1) {
							idx =item.getName().lastIndexOf("/");
						}
						String fileName = item.getName().substring(idx+1);
						File uploadeFile = new File(filePath + "\\" + fileName);
						//File uploadeFile = new File(filePath + File.separator + fileName); 위랑 똑같다
						System.out.println("세팅된 전체 경로 : " + uploadeFile);
						item.write(uploadeFile);
						request.setAttribute("file" + i, request.getContextPath() + "/upload/" + fileName);
						request.setAttribute("fileName"+i, fileName);
					}
				}
					
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("file_result.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
