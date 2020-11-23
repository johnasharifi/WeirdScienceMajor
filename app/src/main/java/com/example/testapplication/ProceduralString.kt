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

class ProceduralString {
    companion object {
        val Intensifiers = arrayOf("super", "poly", "hyper", "extended", "modern", "archaeo", "ordinal")
        val Qualifiers = arrayOf("progressive", "critical", "analytical", "didactic", "material")
        val Fields = arrayOf("neur", "hydr", "hyp", "bi", "bacter", "eccl", "cosm", "astr", "ge", "heli", "immun")
        val Ologies = arrayOf("ology", "ontology", "ography", "anetics", "etics")

        // TODO array of arrays
        fun getRandomIntensifier(): String {
            return Intensifiers[(Intensifiers.count() * Math.random()).toInt()];
        }

        fun getRandomQualifier(): String {
            return Qualifiers[(Qualifiers.count() * Math.random()).toInt()];
        }

        fun getRandomField(): String {
            return Fields[(Fields.count() * Math.random()).toInt()];
        }

        fun getRandomOlogies(): String {
            return Ologies[(Ologies.count() * Math.random()).toInt()];
        }

        // TODO join into R-{bridge} R
        var Bridges = arrayOf("etic ", "ological ")
    }

    val prop1 = getRandomIntensifier() + " "
    val prop2 = getRandomQualifier() + " "
    val prop3 = getRandomField()
    val prop4 = getRandomOlogies()

    public override fun toString(): String {
        // define a threshold after which we do not generate additional specificiers
        val recurseMaxlen = 40;

        val current = prop1 + prop2 + prop3 + prop4;

        if (current.length * 1.0f / recurseMaxlen < Math.random()) {
            val childString = ProceduralString();
            return current + " of " + childString.toString();
        }

        return current;
    }
}
