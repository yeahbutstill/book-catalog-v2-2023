package com.subrutin.catalog.web;

import com.subrutin.catalog.dto.AuthorCreateRequestDTO;
import com.subrutin.catalog.dto.AuthorResponseDTO;
import com.subrutin.catalog.dto.AuthorUpdateRequestDTO;
import com.subrutin.catalog.service.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@Validated
@RequestMapping("/api/v1/author")
public class AuthorResource {
	
	private final AuthorService authorService;
	
	//author detail
	@GetMapping("/{id}/detail")
	public ResponseEntity<AuthorResponseDTO> findAuthorById(@PathVariable String id){
		return ResponseEntity.ok().body(authorService.findAuthorById(id));
	}
	
	@PostMapping("/author")
	public ResponseEntity<Void> createNewAuthor(@RequestBody @Valid List<AuthorCreateRequestDTO> dto){
		authorService.createNewAuthor(dto);
		return ResponseEntity.created(URI.create("/author")).build();
	}
	
	
	@PutMapping("/{authorId}")
	public ResponseEntity<Void> updateAuthor(@PathVariable String authorId, 
		 @RequestBody AuthorUpdateRequestDTO dto){
		authorService.updateAuthor(authorId, dto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{authorId}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable String authorId){
		authorService.deleteAuthor(authorId);
		return ResponseEntity.ok().build();
	}
	

}