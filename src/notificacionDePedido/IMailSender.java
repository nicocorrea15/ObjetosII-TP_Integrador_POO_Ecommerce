package notificacionDePedido;

public interface IMailSender {
	
	public void enviarMail(String emailDestinatario,String titulo, String mensaje);

}
