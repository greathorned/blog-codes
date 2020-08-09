/* 
SUM & DIFFERENCE TONE PITCH GENERATOR TOOL
inspired by CLAUDE VIVIER'S "COLEURS"

Each of the functions below takes a "modulator" and "carrier" pitch
(in MIDI notes) and returns an array of MIDI notes representing the
sum and/or difference tones created by "ring modulating" the two pitches.
Using multiple harmonics of the mod and/or carrier yields a larger
pitch collection and the s/d tones are different in each octave.

Read the original blog post for more information: 
www.lawtonhall.com/blog/claude-viver-coleurs

Free to use, share, and adapt.
Created by Lawton Hall in 2020.
*/

(
/* SUM TONES ONLY with MODULATOR HARMONICS  */

var modPitch, carrierPitch, modHarmonics, ringMod;
modPitch = 60;            // modulator pitch (MIDI note)
carrierPitch = 21;        // carrier pitch (MIDI note)
modHarmonics = 5;         // number of modulator harmonics
ringMod = Array.fill(modHarmonics, {
	|i|
	((modPitch.midicps * (i+1)) + carrierPitch.midicps).abs.cpsmidi;
});
ringMod.postln;
);


(
/* DIFFERENCE TONES ONLY with MODULATOR HARMONICS  */

var modPitch, carrierPitch, modHarmonics, ringMod;
modPitch = 60;            // modulator pitch (MIDI note)
carrierPitch = 21;        // carrier pitch (MIDI note)
modHarmonics = 5;         // number of modulator harmonics
ringMod = Array.fill(modHarmonics, {
	|i|
	((modPitch.midicps * (i+1)) - carrierPitch.midicps).abs.cpsmidi;
});
ringMod.postln;
);


(
/* SUM & DIFFERENCE TONES with MODULATOR HARMONICS  */

var modPitch, carrierPitch, modHarmonics, ringMod;
modPitch = 60;            // modulator pitch (MIDI note)
carrierPitch = 21;        // carrier pitch (MIDI note)
modHarmonics = 5;         // number of modulator harmonics
ringMod = Array.fill(modHarmonics, {
	|i|
	[
		((modPitch.midicps * (i+1)) + carrierPitch.midicps),
		((modPitch.midicps * (i+1)) - carrierPitch.midicps),
	].abs.cpsmidi;
});
ringMod.postln;
);


(
/* SUM & DIFFERENCE TONES with MOD & CARRIER HARMONICS  */

var modPitch, carrierPitch, modHarmonics, carrierHarmonics, ringMod;
modPitch = 60;            // modulator pitch (MIDI note)
carrierPitch = 21;        // carrier pitch (MIDI note)
modHarmonics = 3;         // number of modulator harmonics
carrierHarmonics = 2;     // number of carrier harmonics
ringMod = Array.fill(modHarmonics, {
	|i|
	Array.fill(carrierHarmonics, {
		|j|
		[
			(modPitch.midicps * (i+1)) + (carrierPitch.midicps * (j+1)),
			(modPitch.midicps * (i+1)) - (carrierPitch.midicps * (j+1))
		].abs.cpsmidi;
	})});
ringMod.postln;
);
