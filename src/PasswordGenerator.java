import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;

/*
 * This class responsible for generating
 * strong random password
 */
public class PasswordGenerator {

	private SecureRandom secureRandom;
	private StringBuilder stringBuilder;

	// Defined Password Characters
	private final String lowerCaseAlphabets = "abcdefghijklmnopqrstuvwxyz";
	private final String upperCaseAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final String numbers = "0123456789";
	private final String characters = "!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";

	private final String passwordCharacters = lowerCaseAlphabets + upperCaseAlphabets + numbers + characters;

	// Initialized our secureRandom and stringBuilder variables
	public PasswordGenerator() {
		secureRandom = new SecureRandom();
		stringBuilder = new StringBuilder();

		welcomeMessage();
	}

	// Generated ASCII Welcome Message
	public void welcomeMessage() {
		int width = 180;
		int height = 15;

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();

		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics2D.drawString("PASSWORD GENERATOR", 15, 12);

		for (int y = 0; y < height; y++) {
			StringBuilder sb = new StringBuilder();
			
			for (int x = 0; x < width; x++) {
				sb.append(bufferedImage.getRGB(x, y) == -16777216 ? "|" : " ");
			}

			if (sb.toString().trim().isEmpty()) {
				continue;
			}
			
			System.out.println(sb);
		}
	}

	/*
	 * Requires length parameter for the size of the password Generates
	 * randomPassword using allCharacters by using secureRandom and stringBuilder
	 * libraries
	 */
	public String generateRandomPassword(int length) {
		// loops through the specified length and
		// adds each random index character to the stringBuilder
		// eventually building the generated password string at the end
		for (int i = 0; i < length; i++) {
			int randomIndex = secureRandom.nextInt(passwordCharacters.length());
			stringBuilder.append(passwordCharacters.charAt(randomIndex));
		}
		return "Your Generated Password: " + stringBuilder.toString();

	}

}
