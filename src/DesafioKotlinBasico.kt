import kotlin.system.exitProcess

fun main() {
    cadastrarAluno()
}

fun cadastrarAluno(){
    println("Digite o nome do aluno:")
    val nomeAluno = readln()

    cadastrarNotas(nomeAluno)
}

fun cadastrarNotas(nomeAluno: String){
    val notasDoAluno = DoubleArray(4)

    for(i: Int in notasDoAluno.indices){
        println("Digite a ${i+1}ª nota de $nomeAluno:")
        val notaDigitada = readln().toDouble()

        if(notaDigitada in 0.0..10.0){
            notasDoAluno[i] = notaDigitada
        }
        else{
            println("Nota inválida.\nPor favor, comece novamente.\nA nota deve ser de 0 a 10")
            println("-----------------------------------")
            cadastrarNotas(nomeAluno)
        }
    }

    calcularMedia(nomeAluno, notasDoAluno)
}

fun calcularMedia(nomeAluno: String, notasDoAluno: DoubleArray) {

    var somarNotas = 0.0

    for(i: Int in notasDoAluno.indices){
        somarNotas += notasDoAluno[i]
    }

    val mediaAluno = somarNotas/4.0

    println("--------------------")
    println("Aluno: $nomeAluno")
    println("Média: $mediaAluno")
    println("--------------------")

    menuNovoCalculo()
}

fun menuNovoCalculo(){
    println("Deseja calcular a média de notas de um novo aluno?")
    println("[1] SIM")
    println("[2] NÃO")
    val opcDigitada = readln().toInt()

    when(opcDigitada){
        1 -> main()
        2 -> exitProcess(0)
        else -> menuNovoCalculo()
    }
}