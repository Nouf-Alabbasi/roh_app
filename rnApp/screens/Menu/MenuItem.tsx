import React from "react";
import { Text } from "react-native";
import { Image } from "react-native";
import { StyleSheet, TouchableOpacity } from "react-native";
import { View } from "react-native";
import { useFonts } from "expo-font";
import AppLoading from "expo-app-loading";
import { MenuItem as MenuItemType } from "../../types";
import { SCREEN_PADDING, YELLOW } from "../../variables";

const MenuItem = (props: any) => {
  const menuItemDetails: MenuItemType = props.details;

  let [fontLoaded] = useFonts({
    poetsen: require("../../assets/fonts/poetsenOne/PoetsenOne-Regular.ttf"),
  });

  if (fontLoaded) {
    return (
      <TouchableOpacity
        onPress={() => props.navigation.navigate(menuItemDetails.navName)}
        style={styles.root}
      >
        <View style={styles.imageContainer}>
          <Image style={styles.image} source={menuItemDetails.image} />
        </View>
        <Text style={styles.text}>{menuItemDetails.text}</Text>
      </TouchableOpacity>
    );
  } else {
    return <AppLoading />;
  }
};

const styles = StyleSheet.create({
  root: {
    borderColor: "black",
    borderWidth: 2,
    backgroundColor: YELLOW,
    width: "45%",
    margin: 10,
    padding: 20,
    borderRadius: 50,
    flexDirection: "column",
    justifyContent: "space-evenly",
    alignItems: "center",
  },
  imageContainer: {
    width: "80%",
    // borderColor: "black",
    // borderWidth: 3
  },
  image: {
    top: -15,
    width: "100%",
    resizeMode: "contain",
  },
  text: {
    top: -15,
    fontSize: 30,
    textAlign: "center",
    fontFamily: "poetsen",
  },
});

export default MenuItem;
