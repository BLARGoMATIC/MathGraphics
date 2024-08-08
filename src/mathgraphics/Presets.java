package mathgraphics;

public enum Presets {
	UNMODIFIED (new Options("5 - Unrestricted Pentagon", new int[] {
			5,			//Number of Sides
			10000000,	//Number of Iterations
			31,
			31,		
	}, false, true, new VertexRestrictions[] { 
			new VertexRestrictions( //Initializing an array of arrays is a pain in the ass
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							false, //offset1Preference
							false, //offset1True
							false, //offset2Preference
							false  //offset2True
					},
					new int[] {
							0,
							0
					}), 
			new VertexRestrictions( //second set of vertex restrictions for restricting choices of the current vertex in regards to the vertex chosen before last
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							false, //offset1Preference
							false, //offset1True
							false, //offset2Preference
							false  //offset2True
					},
					new int[] {
							0,
							0
					})
	})),
	FACES (new Options("5- Pentagon Faces", new int[] {
			5,			//Number of Sides
			10000000,	//Number of Iterations
			30,
			31
	}, false, true, new VertexRestrictions[] { 
			new VertexRestrictions( //Initializing an array of arrays is a pain in the ass
					new boolean[] {
							true, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							false, //offset1Preference
							false, //offset1True
							false, //offset2Preference
							false  //offset2True
					},
					new int[] {
							0,
							0
					}), 
			new VertexRestrictions( //second set of vertex restrictions for restricting choices of the current vertex in regards to the vertex chosen before last
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							false, //offset1Preference
							false, //offset1True
							false, //offset2Preference
							false  //offset2True
					},
					new int[] {
							0,
							0
					})
	})),
	SIERPINKSKI (new Options("3 - Sierpinski Triangle", new int[] {
			3,			//Number of Sides
			10000000,	//Number of Iterations
			111,
			111
	}, false, true, new VertexRestrictions[] { 
			new VertexRestrictions( //Initializing an array of arrays is a pain in the ass
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							false, //offset1Preference
							false, //offset1True
							false, //offset2Preference
							false  //offset2True
					},
					new int[] {
							0,
							0
					}), 
			new VertexRestrictions( //second set of vertex restrictions for restricting choices of the current vertex in regards to the vertex chosen before last
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							false, //offset1Preference
							false, //offset1True
							false, //offset2Preference
							false  //offset2True
					},
					new int[] {
							0,
							0
					})
	})),
	HEPTAGONALSTAR (new Options("7 - Heptagonal Star", new int[] {
			7,			//Number of Sides
			10000000,	//Number of Iterations
			25,
			25
	}, true, true, new VertexRestrictions[] { 
			new VertexRestrictions( //Initializing an array of arrays is a pain in the ass
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							true, //adjacentPreference
							false, //adjacentTrue
							true, //offset1Preference
							false, //offset1True
							true, //offset2Preference
							false  //offset2True
					},
					new int[] {
							5,
							2
					}), 
			new VertexRestrictions( //second set of vertex restrictions for restricting choices of the current vertex in regards to the vertex chosen before last
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							true, //adjacentPreference
							false, //adjacentTrue
							true, //offset1Preference
							false, //offset1True
							true, //offset2Preference
							false  //offset2True
					},
					new int[] {
							5,
							2
					})
	})),
	BIOHAZARD (new Options("9 - Biohazard Nonagram", new int[] {
			9,			//Number of Sides
			10000000,	//Number of Iterations
			380,
			491
	}, false, true, new VertexRestrictions[] { 
			new VertexRestrictions( //Initializing an array of arrays is a pain in the ass
					new boolean[] {
							true, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							true, //offset1Preference
							false, //offset1True
							true, //offset2Preference
							false  //offset2True
					},
					new int[] {
							1,
							7
					}), 
			new VertexRestrictions( //second set of vertex restrictions for restricting choices of the current vertex in regards to the vertex chosen before last
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							true, //offset1Preference
							false, //offset1True
							true, //offset2Preference
							false  //offset2True
					},
					new int[] {
							4,
							2
					})
	})),
	SNOWFLAKE (new Options("6 - Hexagonal Snowflake", new int[] {
			6,			//Number of Sides
			10000000,	//Number of Iterations
			125,
			57
	}, false, true, new VertexRestrictions[] { 
			new VertexRestrictions( //Initializing an array of arrays is a pain in the ass
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							true, //offset1Preference
							false, //offset1True
							true, //offset2Preference
							false  //offset2True
					},
					new int[] {
							4,
							2
					}), 
			new VertexRestrictions( //second set of vertex restrictions for restricting choices of the current vertex in regards to the vertex chosen before last
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							true, //adjacentPreference
							false, //adjacentTrue
							false, //offset1Preference
							false, //offset1True
							false, //offset2Preference
							false  //offset2True
					},
					new int[] {
							0,
							0
					})
	})),
	OCTAGONALSNOWFLAKE (new Options("8 - Octagonal Snowflake", new int[] {
			8,			//Number of Sides
			10000000,	//Number of Iterations
			125,
			57
	}, false, true, new VertexRestrictions[] { 
			new VertexRestrictions( //Initializing an array of arrays is a pain in the ass
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							true, //adjacentPreference
							false, //adjacentTrue
							false, //offset1Preference
							false, //offset1True
							false, //offset2Preference
							false  //offset2True
					},
					new int[] {
							0,
							0
					}), 
			new VertexRestrictions( //second set of vertex restrictions for restricting choices of the current vertex in regards to the vertex chosen before last
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							true, //adjacentPreference
							false, //adjacentTrue
							true, //offset1Preference
							false, //offset1True
							true, //offset2Preference
							false  //offset2True
					},
					new int[] {
							6,
							2
					})
	})),
	CHAOSSQUARE (new Options("4 - Chaos Square", new int[] {
			4,			//Number of Sides
			10000000,	//Number of Iterations
			12,
			12
	}, true, true, new VertexRestrictions[] { 
			new VertexRestrictions( //Initializing an array of arrays is a pain in the ass
					new boolean[] {
							true, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							true, //offset1Preference
							false, //offset1True
							false, //offset2Preference
							false  //offset2True
					},
					new int[] {
							1,
							0
					}), 
			new VertexRestrictions( //second set of vertex restrictions for restricting choices of the current vertex in regards to the vertex chosen before last
					new boolean[] {
							true, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							true, //offset1Preference
							false, //offset1True
							false, //offset2Preference
							false  //offset2True
					},
					new int[] {
							1,
							0
					})
	})),
	TWISTEDSTAR (new Options("6 - Hexagonal Twisted Star", new int[] {
			6,			//Number of Sides
			10000000,	//Number of Iterations
			47,
			61
	}, false, true, new VertexRestrictions[] { 
			new VertexRestrictions( //Initializing an array of arrays is a pain in the ass
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							true, //offset1Preference
							false, //offset1True
							false, //offset2Preference
							false  //offset2True
					},
					new int[] {
							4,
							0
					}), 
			new VertexRestrictions( //second set of vertex restrictions for restricting choices of the current vertex in regards to the vertex chosen before last
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							true, //offset1Preference
							false, //offset1True
							false, //offset2Preference
							false  //offset2True
					},
					new int[] {
							1,
							0
					})
	})),
	OCTAGONALFACES (new Options("8 - Octagonal Faces", new int[] {
			8,			//Number of Sides
			10000000,	//Number of Iterations
			186,
			254
	}, false, true, new VertexRestrictions[] { 
			new VertexRestrictions( //Initializing an array of arrays is a pain in the ass
					new boolean[] {
							true, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							true, //offset1Preference
							false, //offset1True
							true, //offset2Preference
							false  //offset2True
					},
					new int[] {
							6,
							2
					}), 
			new VertexRestrictions( //second set of vertex restrictions for restricting choices of the current vertex in regards to the vertex chosen before last
					new boolean[] {
							true, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							false, //offset1Preference
							false, //offset1True
							false, //offset2Preference
							false  //offset2True
					},
					new int[] {
							0,
							0
					})
	})),
	RIGIDOCTAGRAM (new Options("8 - Rigid Octagram", new int[] {
			8,			//Number of Sides
			10000000,	//Number of Iterations
			57,
			255
	}, false, true, new VertexRestrictions[] { 
			new VertexRestrictions( //Initializing an array of arrays is a pain in the ass
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							true, //adjacentPreference
							false, //adjacentTrue
							true, //offset1Preference
							false, //offset1True
							true, //offset2Preference
							false  //offset2True
					},
					new int[] {
							6,
							2
					}), 
			new VertexRestrictions( //second set of vertex restrictions for restricting choices of the current vertex in regards to the vertex chosen before last
					new boolean[] {
							false, //equivalencePreference
							false, //equivalenceTrue
							false, //adjacentPreference
							false, //adjacentTrue
							false, //offset1Preference
							false, //offset1True
							false, //offset2Preference
							false  //offset2True
					},
					new int[] {
							0,
							0
					})
	})),
	OCTALSTARFISH (new Options("8 - Octal Starfish", new int[] {
			8,			//Number of Sides
			10000000,	//Number of Iterations
			56,
			110
	}, true, true
	)),
	DECAGONSPIKEDWHEEL (new Options("10 - Spiked Wheel", new int[] {
			8,			//Number of Sides
			10000000,	//Number of Iterations
			56,
			110
	}, true, true
	)),
	
	;

	private Options options;

	/**
	 * @return the options
	 */
	public Options getOptions() {
		return options;
	}

	Presets(Options options) {
		this.options = options;
	}
	
	@Override
	public String toString() {
		return options.name;
	}
}
