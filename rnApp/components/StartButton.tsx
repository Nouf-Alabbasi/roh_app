import { StyleSheet, Text, TouchableOpacity, View } from "react-native"
import {useFonts} from "expo-font"
import React, { useEffect, useState } from "react"
import AppLoading from 'expo-app-loading';
import { YELLOW } from "../variables";


const StartButton = (props: any) => {
    
    let [fontLoaded] = useFonts({
        piedra: require("../assets/fonts/Piedra-Regular.ttf")
    })

    if (fontLoaded) {
        return <TouchableOpacity onPress={props.onPress} style={styles.startButton}>
            <Text style={styles.startText}>Click here to start!</Text>
        </TouchableOpacity>
    } else {
        return <AppLoading />
    }

    
}

const styles = StyleSheet.create({
    startButton: {
        backgroundColor: YELLOW,
        borderRadius: 100,
        padding: 20,
        margin: 40
    },
    startText: {
        fontSize: 30,
        fontFamily: "piedra"
    } 
})

export default StartButton