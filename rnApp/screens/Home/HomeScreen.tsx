import React from "react";
import { Image, ImageBackground, StyleSheet, Text, View } from "react-native";
import { TouchableOpacity } from "react-native-gesture-handler";
import StartButton from "../../components/StartButton";
import { BACKGROUND_COLOR } from "../../variables";

const HomeScreen = ({ navigation }: { navigation: any }) => {
  return (
    <View style={styles.root}>
      <ImageBackground
        source={require("./images/background.png")}
        style={styles.background}
      >
        <StartButton onPress={() => navigation.navigate("Menu")} />
        <Image source={require("./images/girl.png")} style={styles.girl} />
      </ImageBackground>
    </View>
  );
};

const styles = StyleSheet.create({
  root: {
    backgroundColor: BACKGROUND_COLOR,
    flex: 1,
    height: "100%",
    flexDirection: "column",
  },
  background: {
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "flex-end",
    height: "100%",
    resizeMode: "cover",
  },
  girl: {
    paddingBottom: "30%",
    resizeMode: "contain",
  },
});

export default HomeScreen;
