import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    //Resumidamente, Lambda é uma forma curta de escrever funções no Java transfromando a para uma função anonima
    //Por exemplo        
    //public void run() pode ser transformado para: () -> funcao_predefinida()


    //Temos também a realização de interfaces funcionais, que são interfaces com apenas um método abstrato
    //Podemos usar ele com o lambda:
    //@FunctionalInterface
    //public interface Calculadora {
    //  int calcular(int a, int b); 
    //}

    //Calculadora soma = (a, b) -> a + b
    //System.out.println(soma.calcular(2, 3))


    //O Java tem de forma nativa algumas interfaces prontas, como Function, Consumer, Supplier e Predicate
    //Function:
    //Function<String, Integer> tamanho = s -> s.length() -----> O primeiro parametro é o que passamos e o segundo é o que a função retorna
    //System.out.println(tamanho.apply("Gabriel")) -----> Vai retornar 7

        
    //Consumer:
    //Consumer<String> imprimir = s -> System.out.println(s) -----> Interface que só consome
    //imprimir.accept("Hello World")
        

    //Supplier:
    //Supplier<Double> aleatorio = () -> Math.random() -----> Interface que só retorna
    //System.out.println(aleatorio.get())

    
    //Predicate:
    //Predicate<Integer> par = n -> n % 2 == 0 -----> Interface que retorna booleano
    //System.out.println(par.test(4)) -----> Vai retornar true

    public static void main(String[] args) {
        List<UsuarioRequestDto> usuariosRequest = usuariosRequest();

        usuariosRequest.stream()
                .forEach(new MeuConsumer());

        usuariosRequest.stream()
                .forEach(u -> System.out.println());

        usuariosRequest.stream()
                .map(new MinhaFunction()).toList().forEach(System.out::println);

        usuariosRequest.stream()
                .map(u -> new UsuarioResponseDto(u.nome(), u.email(), u.idade())).toList().forEach(System.out::println);


        usuariosRequest.stream()
                .filter(new MeuPredicate()).toList().forEach(System.out::println);

        usuariosRequest.stream()
                .filter(u -> u.idade() >= 18).toList().forEach(System.out::println);
    }

    // Utilizado no Stream.generate
    public static class MeuSupplier implements Supplier<UsuarioRequestDto> {

        @Override
        public UsuarioRequestDto get() {
            return new UsuarioRequestDto("Matheus", "matheus@dev.com", "123", 30);
        }
    }

    // Utilizado no MAP
    public static class MinhaFunction implements Function<UsuarioRequestDto, UsuarioResponseDto> {

        @Override
        public UsuarioResponseDto apply(UsuarioRequestDto request) {
            return new UsuarioResponseDto(request.nome(), request.email(), request.idade());
        }
    }

    // Utilizado no FILTER
    public static class MeuPredicate implements Predicate<UsuarioRequestDto> {

        @Override
        public boolean test(UsuarioRequestDto usuarioRequestDto) {
            return usuarioRequestDto.idade() >= 18;
        }
    }

    // Utilizado no Foreach
    public static class MeuConsumer implements Consumer<UsuarioRequestDto> {

        @Override
        public void accept(UsuarioRequestDto usuarioRequest) {
            System.out.println(usuarioRequest.idade());
        }
    }

    public static List<UsuarioRequestDto> usuariosRequest() {
        return Arrays.asList(new UsuarioRequestDto("Matheus", "matheus@dev.com.br", "123", 10),
                new UsuarioRequestDto("Marcos", "marcos@dev.com.br", "456", 16),
                new UsuarioRequestDto("Lucas", "lucas@dev.com.br", "789", 55),
                new UsuarioRequestDto("João", "joao@dev.com.br", "101", 42)
        );
    }
}