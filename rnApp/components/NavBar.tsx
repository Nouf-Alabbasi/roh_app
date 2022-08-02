import React from "react"
import { Button, Text } from "react-native"
import { StyleSheet, View } from "react-native"
import { YELLOW } from "../variables"
import {useNavigation} from "@react-navigation/native"
export default function NavBar() {
    const navigation = useNavigation()
    
    return <View style={styles.root}>
        <Button onPress={() => navigation.navigate("Home")} title="Home" />
        <Text>Next Icon</Text>
    </View>
}

const styles = StyleSheet.create({
    root: {
        flexDirection: "row",
        height: "7%",
        backgroundColor: YELLOW,
        justifyContent: "space-evenly",
        alignItems: "center"
    }
})