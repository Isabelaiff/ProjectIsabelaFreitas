package com.example.springapipraticaofc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoController(TransacaoRepository transacaoRepository){
        this.transacaoRepository = transacaoRepository;
    }


    @PostMapping("/inserir")
    public ResponseEntity<String> inserirTransacao(@RequestBody Transacao transacao){
        transacaoRepository.save(transacao);
        return ResponseEntity.ok("Transação Inserida com Sucesso!");
    }
    @GetMapping("/selecionar")
    public List<Transacao> listarTransacoes(){
        return transacaoRepository.findAll();
    }


    @GetMapping("/selecionar/{id}")
    public ResponseEntity<Transacao> getProdutoById(@PathVariable int id){
        if(transacaoRepository.existsById(id)){
            Transacao transacao = transacaoRepository.findById(id).orElse(null);
            return ResponseEntity.ok(transacao);
        }
        else{
            return  ResponseEntity.notFound().build();
        }

    }


    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> deletarTransacao(@PathVariable int id){

        transacaoRepository.deleteById(id);
        return ResponseEntity.ok("Transação deletada com sucesso");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarTransacao(@PathVariable int id,
                                                   @RequestBody Transacao transacaoAtualizada) {
        Optional<Transacao> transacaoOptional = transacaoRepository.findById(id);
        if(transacaoOptional.isPresent()){
            Transacao transacao = transacaoAtualizada;
            if(transacaoAtualizada.getDescricao() != null) {
                transacao.setDescricao(transacaoAtualizada.getDescricao());
            }
            else{
                transacao.setDescricao(transacaoOptional.get().getDescricao());
            }
            if(transacaoAtualizada.getValor() != 0) {
                transacao.setValor(transacaoAtualizada.getValor());
            }
            else{
                transacao.setValor(transacaoOptional.get().getValor());

            }
            if(transacaoAtualizada.getTipo_transacao() != null) {
                transacao.setTipo_transacao(transacaoAtualizada.getTipo_transacao());
            }
            else{
                transacao.setTipo_transacao(transacaoOptional.get().getTipo_transacao());
            }
            if(transacaoAtualizada.getData_transacao() != null) {
                transacao.setData_transacao(transacaoAtualizada.getData_transacao());
            }
            else{
                transacao.setData_transacao(transacaoOptional.get().getData_transacao());

            }

            transacao.setId(transacaoOptional.get().getId());

            transacaoRepository.save(transacao);
            return  ResponseEntity.ok("Transação Atualizada!");
        }else{
            return ResponseEntity.notFound().build();
        }

    }





}
