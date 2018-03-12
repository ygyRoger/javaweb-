package com.liuzhen.chart;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class InputInformation extends HttpServlet {
	public String chat_record = "";  //���������¼�������˴�Ϊȫ�ֱ���

	/**
	 * Constructor of the object.
	 */
	public InputInformation() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//response.setContentType("text/html;charset=utf-8"); 
		//�˳�ע������Ϊʹ��CodeFilter���������Servlet��ת������
		//request.setCharacterEncoding("utf-8");
		String input_textarea = request.getParameter("input_textarea");
		Date now = new Date();    //�������ڶ��󣬼�ϵͳ��ǰʱ��
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		String time = dateFormat.format( now ); //���ո��������ڸ�ʽ��ȡϵͳ��ǰʱ��
		String t = (String)request.getSession().getAttribute("nameSession");  //��ȡ��½ҳ���û���
		chat_record += t+"  "+input_textarea+"  "+time+"\n";   //�����¼�洢
		request.setAttribute("input_textarea",chat_record); //����ǰ�����������ݴ洢
		request.getRequestDispatcher("main.jsp").forward(request,response);  //��ת����ǰ����������棬�����沼�ֲ���
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
