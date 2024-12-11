package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.NotebookDTO;
import beatrizbonatto.com.dto.ProdutoDTO;
import beatrizbonatto.com.model.Produtos.Notebook;
import beatrizbonatto.com.model.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ProdutoMapper {
    NotebookDTO toNotebookDTO(Notebook notebook);

    ProdutoDTO toDTO(Produto produto);
}
