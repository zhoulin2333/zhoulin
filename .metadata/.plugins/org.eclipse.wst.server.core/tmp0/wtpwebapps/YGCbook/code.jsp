<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK" 
     import="java.io.*,
          java.util.*,
          com.sun.image.codec.jpeg.*,
          java.awt.*,
          java.awt.image.*"%>


<%	String s = "";

        int intCount = 0;
        /**
      * ��֤����
      */
      int width=100;
     /**
      * ��֤��߶�
      */
      int height=25;
        /**
      * ��֤���ַ���
      */
      char[] code=new char[]{
      'A','B','C','D','E','F','G','H','I','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z',
      'a','b','c','d','e','f','g','h','i','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z',
       '2','3','4','5','6','7','8','9','��','��','��','��','��','��','˱','��','��','��','Ц','��','С','��'};
     
        /**
         *  ����һ���������������
         */
        Random random = new Random();  

       
       // �������codeCount���ֵ���֤�롣   
        for (int i = 0; i < 4; i++) {   
            // �õ������������֤�����֡�   
            String strRand = String.valueOf(code[random.nextInt(code.length)]);   
        
            // ���������ĸ�����������һ��   
            s=s+strRand;   
        } 

        // ������session,�������û���������бȽ�.
        // ע��Ƚ���֮�����session.

        session.setAttribute("validateCode", s);

        response.setContentType("image/gif");
        

   // ����ͼ��buffer   
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D gra = image.createGraphics(); 
      // ��ͼ�����Ϊ��ɫ   
        gra.setColor(Color.WHITE);   
        gra.fillRect(0, 0, width, height);   
  
        // �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������  
       
       //��������췽��public Font(String familyName,int style,int size)
       // familyName�����������������Էֳ������ࣺ�������壺���塢���塢����ȣ�Ӣ�����壺Arial��Times New Roman�ȵȣ�
       // style���PLAIN��ͨ���壬BOLD���Ӵ֣���ITALIC��б�壩��Font.BOLD+ Font.ITALIC����б�壩
       //size ��С

       
        Font font = new Font("����", Font.BOLD+Font.ITALIC, height-1);//
  
       
        // �������塣   
        gra.setFont(font);   
  
  
        // ���߿�   
        gra.setColor(getColor());   
        gra.drawRect(0, 0, width - 1, height - 1); 
   
  
        // ������������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��   
        gra.setColor(Color.BLACK);   
        for (int i = 0; i < 50; i++) {   
            int x = random.nextInt(width);   
            int y = random.nextInt(height);   
            int xl = random.nextInt(5);   
            int yl = random.nextInt(5);  
            gra.setColor(getColor());
            gra.drawLine(x, y, x + xl, y + yl);   
        }   
      
        // �������
        char c;

        for (int i = 0; i < 4; i++) {

            c = s.charAt(i);

            gra.drawString(c + "", i * 25 + 4, 20); // 25Ϊ��ȣ�11Ϊ���¸߶�λ��

        }

  OutputStream toClient = response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(toClient);
        encoder.encode(image);

  toClient.close();

        out.clear();

  out = pageContext.pushBody();
%>
<%!
private Color getColor()
{
 Random random = new Random();
 int red = 0, green = 0, blue = 0;   
 // �����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ��   
     red = random.nextInt(255);   
     green = random.nextInt(255);   
     blue = random.nextInt(255);  
     return new Color(red,green,blue);
}

