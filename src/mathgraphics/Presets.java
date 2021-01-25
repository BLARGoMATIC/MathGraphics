package mathgraphics;

public enum Presets {
	BLANK (new Options("Blank", new int[] {
			5,			//Number of Sides
			10000000	//Number of Iterations
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
	MONKE (new Options("Monke", new int[] {
			5,			//Number of Sides
			10000000	//Number of Iterations
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
	SIERPINKSKI (new Options("Sierpinski Triangle", new int[] {
			3,			//Number of Sides
			10000000	//Number of Iterations
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
	HEPTAGONALSTAR (new Options("Heptagonal Star", new int[] {
			7,			//Number of Sides
			10000000	//Number of Iterations
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
	BIOHAZARD (new Options("Biohazard Nonagram", new int[] {
			9,			//Number of Sides
			10000000	//Number of Iterations
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
	SNOWFLAKE (new Options("Heptagonal Snowflake", new int[] {
			6,			//Number of Sides
			10000000	//Number of Iterations
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
	CHAOSSQUARE (new Options("Chaos Square", new int[] {
			4,			//Number of Sides
			10000000	//Number of Iterations
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
	TWISTEDSTAR (new Options("Hexagonal Twisted Star", new int[] {
			6,			//Number of Sides
			10000000	//Number of Iterations
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
