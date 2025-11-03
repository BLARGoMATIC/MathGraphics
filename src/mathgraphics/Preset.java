package mathgraphics;

import com.fasterxml.jackson.annotation.*;

public enum Preset {
	BLANK_SQUARE (new Options("Unrestricted Square", new int[] {
			4,			//Number of Sides
			10000000,	//Number of Iterations
			0b1111,
			0b1111,		
	}, false, true)),
	BLANK_PENTAGON (new Options("Unrestricted Pentagon", new int[] {
			5,			//Number of Sides
			10000000,	//Number of Iterations
			31,
			31,		
	}, false, true)),
	BLANK_HEXAGON (new Options("Unrestricted Hexagon", new int[] {
			6,			//Number of Sides
			10000000,	//Number of Iterations
			0b111111,
			0b111111,		
	}, false, true)),
	BLANK_HEPTAGON (new Options("Unrestricted Heptagon", new int[] {
			7,			//Number of Sides
			10000000,	//Number of Iterations
			0b1111111,
			0b1111111,		
	}, false, true)),
	BLANK_OCTAGON (new Options("Unrestricted Octagon", new int[] {
			8,			//Number of Sides
			10000000,	//Number of Iterations
			0b11111111,
			0b11111111,		
	}, false, true)),
	BLANK_NONAGON (new Options("Unrestricted Nonagon", new int[] {
			9,			//Number of Sides
			10000000,	//Number of Iterations
			0b111111111,
			0b111111111,		
	}, false, true)),
	BLANK_DECAGON (new Options("Unrestricted Decagon", new int[] {
			10,			//Number of Sides
			10000000,	//Number of Iterations
			0b1111111111,
			0b1111111111,		
	}, false, true)),
	FACES (new Options("Pentagon Faces", new int[] {
			5,			//Number of Sides
			10000000,	//Number of Iterations
			30,
			31
	}, false, true)),
	SIERPINSKI (new Options("Sierpinski Triangle", new int[] {
			3,			//Number of Sides
			10000000,	//Number of Iterations
			111,
			111
	}, false, true)),
	HEPTAGONALSTAR (new Options("Heptagonal Star", new int[] {
			7,			//Number of Sides
			10000000,	//Number of Iterations
			25,
			25
	}, false, true)),
	BIOHAZARD (new Options("Biohazard Nonagram", new int[] {
			9,			//Number of Sides
			10000000,	//Number of Iterations
			380,
			491
	}, true, true)),
	SNOWFLAKE (new Options("Hexagonal Snowflake", new int[] {
			6,			//Number of Sides
			10000000,	//Number of Iterations
			43,
			29
	}, true, true)),
	OCTAGONALSNOWFLAKE (new Options("Octagonal Snowflake", new int[] {
			8,			//Number of Sides
			10000000,	//Number of Iterations
			125,
			57
	}, true, true)),
	CHAOSSQUARE (new Options("Chaos Square", new int[] {
			4,			//Number of Sides
			10000000,	//Number of Iterations
			12,
			12
	}, false, true)),
	TWISTEDSTAR (new Options("Hexagonal Twisted Star", new int[] {
			6,			//Number of Sides
			10000000,	//Number of Iterations
			47,
			61
	}, true, true)),
	OCTAGONALFACES (new Options("Octagonal Faces", new int[] {
			8,			//Number of Sides
			10000000,	//Number of Iterations
			186,
			254
	}, true, true)),
	RIGIDOCTAGRAM (new Options("Rigid Octagram", new int[] {
			8,			//Number of Sides
			10000000,	//Number of Iterations
			57,
			255
	}, true, true)),
	OCTALSTARFISH (new Options("Octal Starfish", new int[] {
			8,			//Number of Sides
			10000000,	//Number of Iterations
			56,
			110
	}, true, true)),
	DECAGONSPIKEDWHEEL (new Options("Spiked Wheel", new int[] {
			10,			//Number of Sides
			10000000,	//Number of Iterations
			119,
			841
	}, true, true)),
	COOLDECAGRAM (new Options("Cool Decagram Thing", new int[] {
			10,			//Number of Sides
			10000000,	//Number of Iterations
			41,
			72
	}, false, true)),
	ELDRITCHSQUID (new Options("Eldritch Squid", new int[] {
			10,			//Number of Sides
			10000000,	//Number of Iterations
			56,
			16
	}, false, true)),
	LEAFYWREATH (new Options("Leafy Wreath", new int[] {
			10,			//Number of Sides
			10000000,	//Number of Iterations
			824,
			285
	}, true, true)),
	NINJASTAR (new Options("Ninja Star", new int[] {
			10,			//Number of Sides
			10000000,	//Number of Iterations
			121,
			950
	}, true, true))
	;

	public final Options options;

	/**
	 * @return the options
	 */@JsonProperty("Options") 
	public Options getOptions() {
		return options;
	}

	Preset(Options options) {
		this.options = options;
	}
	
	@Override
	public String toString() {
		return options.name;
	}
}

enum PresetGroup { 
	Triangle (3, new Preset[] {
			Preset.SIERPINSKI,
	}),
	Square (4, new Preset[] {
			Preset.BLANK_SQUARE,
			Preset.CHAOSSQUARE,
	}),
	Pentagon (5, new Preset[] {
			Preset.BLANK_PENTAGON,
			Preset.FACES,
	}),
	Hexagon (6, new Preset[] {
			Preset.BLANK_HEXAGON,
			Preset.SNOWFLAKE,
			Preset.TWISTEDSTAR,
	}),
	Heptagon (7, new Preset[] {
			Preset.BLANK_HEPTAGON,
			Preset.HEPTAGONALSTAR,
	}),
	Octagon (8, new Preset[] {
			Preset.BLANK_OCTAGON,
			Preset.OCTAGONALSNOWFLAKE,
			Preset.OCTAGONALFACES,
			Preset.RIGIDOCTAGRAM,
			Preset.OCTALSTARFISH,
	}),
	Nonagon (9, new Preset[] {
			Preset.BLANK_NONAGON,
			Preset.BIOHAZARD,
	}),
	Decagon (10, new Preset[] {
			Preset.BLANK_DECAGON,
			Preset.COOLDECAGRAM,
			Preset.ELDRITCHSQUID,
			Preset.LEAFYWREATH,
			Preset.DECAGONSPIKEDWHEEL,
	});
	private final Preset[] presets;
	public final int numSides;
	
	public Preset[] getPresets() {
		return presets;
	}

	PresetGroup(int numSides, Preset[] presets) {
		this.presets = presets;
		this.numSides = numSides;
	}

}

