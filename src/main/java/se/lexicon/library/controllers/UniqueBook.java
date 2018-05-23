package se.lexicon.library.controllers;

import java.util.UUID;

import se.lexicon.library.domain.Book;

public class UniqueBook extends Book {
	private UUID uuid;

	
	public UniqueBook() {
		super();
	}

	public UniqueBook(UUID uuid) {
		super();
		this.uuid = uuid;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	
}
