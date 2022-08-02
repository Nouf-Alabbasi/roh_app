import React from "react";
import { ImageBackground } from "react-native";
import { Text, View, StyleSheet } from "react-native";
import { useFonts } from "expo-font";
import AppLoading from "expo-app-loading";
import { MenuItem as MenuItemType } from "../../types";
import { BACKGROUND_COLOR, SCREEN_PADDING, YELLOW } from "../../variables";
import MenuItem from "./MenuItem";

const menuItems: Array<MenuItemType> = [
  {
    title: "letterHunt",
    image: require("./images/LetterHunt.png"),
    text: "Letter Hunt with Mr. Monkey",
    navName: "LetterHuntMain",
  },
  {
    title: "counting",
    image: require("./images/Counting.png"),
    text: "Counting with Mama Cow",
    navName: "CountingMain",
  },
  {
    title: "ready",
    image: require("./images/Ready.png"),
    text: "Let's Get Ready With Bontle",
    navName: "ReadyMain",
  },
  {
    title: "imagine",
    image: require("./images/Imagine.png"),
    text: "Imagine Time!",
    navName: "ImagineMain",
  },
];

const Menu = ({ navigation }: { navigation: any }) => {
  let [fontLoaded] = useFonts({
    poetsen: require("../../assets/fonts/poetsenOne/PoetsenOne-Regular.ttf"),
  });
  if (fontLoaded) {
    return (
      <ImageBackground
        style={styles.bgImage}
        source={require("./images/MenuBackground.png")}
      >
        <View style={styles.menuItemsContainer}>
          {[menuItems[0], menuItems[1]].map((menuItem) => {
            return (
              <MenuItem
                navigation={navigation}
                key={menuItem.title}
                details={menuItem}
              />
            );
          })}
        </View>

        <Text style={styles.menuText}>Menu</Text>

        <View style={styles.menuItemsContainer}>
          {[menuItems[2], menuItems[3]].map((menuItem) => {
            return (
              <MenuItem
                navigation={navigation}
                key={menuItem.title}
                details={menuItem}
              />
            );
          })}
        </View>
      </ImageBackground>
    );
  } else {
    return <AppLoading />;
  }
};

const styles = StyleSheet.create({
  root: {
    flex: 1,
  },
  bgImage: {
    padding: SCREEN_PADDING,
    backgroundColor: BACKGROUND_COLOR,
    resizeMode: "cover",
    height: "100%",
  },
  menuItemsContainer: {
    justifyContent: "space-around",
    flexDirection: "row",
    height: "40%",
    //   borderColor: "red",
    //   borderWidth: 4
  },
  menuText: {
    textAlign: "center",
    color: YELLOW,
    textShadowColor: "black",
    textShadowOffset: { width: 0, height: 0 },
    textShadowRadius: 4,
    margin: 50,
    fontSize: 50,
    fontFamily: "poetsen",
  },
});

export default Menu;
