package src.main;
/**
 * Exceção lançada quando uma nota está fora do limite estabelecido
 * NotaInvalidaException
 */
public class NotaInvalidaException extends RuntimeException {
/**
 * Construtor da classe NotaInvalidaException
 * @param mensagem A mensagem que descreve o motivo do erro
 */
    public NotaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
