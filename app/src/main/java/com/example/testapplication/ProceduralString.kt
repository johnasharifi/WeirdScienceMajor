package com.example.testapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class ProceduralString(parentLength: Int) {
    private var parentLength: Int = 0

    companion object {
        private val Intensifiers = arrayOf("super-", "poly", "hyper", "extended ", "modern ", "archaeo", "ordinal ", "applied ", "mechno", "techno", "micro")
        private val Qualifiers = arrayOf("progressive ", "critical ", "analytical ", "didactic ", "material ", "forensic ")
        private val VerbOf = arrayOf("analysis of ", "study of ", "critique of ", "investigation of ", "research into ", "assay of ", "partition of ")
        private val Fields = arrayOf("neur", "hydr", "hyp", "bi", "bacter", "eccl", "cosm", "astr", "ge", "heli", "immun", "anthr", "psych")
        private val Ologies = arrayOf("ology", "ontology", "ography", "anetics", "etics", "oscience", "omedicine", "onautics", "omistry")
        private val BridgingTokens = arrayOf(" with applications in ", " with an emphasis on ")

        fun getRandomIntensifier(): String {
            return Intensifiers[(Intensifiers.count() * Math.random()).toInt()];
        }

        fun getRandomQualifier(): String {
            return Qualifiers[(Qualifiers.count() * Math.random()).toInt()];
        }

        fun getRandomVerbOf(): String {
            return VerbOf[(VerbOf.count() * Math.random()).toInt()];
        }

        fun getRandomField(): String {
            return Fields[(Fields.count() * Math.random()).toInt()];
        }

        fun getRandomOlogies(): String {
            return Ologies[(Ologies.count() * Math.random()).toInt()];
        }

        fun getRandomStudyVerb(): String {
            return BridgingTokens[(BridgingTokens.count() * Math.random()).toInt()];
        }

        // define a threshold after which we do not generate an additional substring
        private const val adjectiveThreshold = 0.3;
        private const val recurseMaxlen = 40;
    }

    private val prop1 = if (adjectiveThreshold < Math.random()) "" else getRandomIntensifier();
    private val prop2 = if (adjectiveThreshold < Math.random()) "" else getRandomQualifier();
    private val prop3 = if (adjectiveThreshold < Math.random()) "" else getRandomVerbOf();

    private val prop4 = getRandomField()
    private val prop5 = getRandomOlogies()

    private var current = "";
    init{
        current = prop1 + prop2 + prop3 + prop4 + prop5;

        if ((current.length + parentLength) * 1.0f / recurseMaxlen < Math.random()) {
            val childString = ProceduralString(current.length + parentLength);
            current += getRandomStudyVerb() + childString.toString();
        }

        // only if root ProceduralString do we want to print out content
        if (parentLength == 0)
            println(current)
    }

    public override fun toString(): String {
        return current;
    }
}
