package de.hybris.platform.sdhpsaddon.forms;

import de.hybris.platform.acceleratorstorefrontcommons.forms.LoginForm;

import javax.validation.constraints.AssertTrue;

public class SDHLoginForm extends LoginForm {

	@AssertTrue(message="login.not.a.robot.error")
	private boolean notARobot;

	public boolean isNotARobot() {
		return notARobot;
	}

	public void setNotARobot(final boolean notARobot) {
		this.notARobot = notARobot;
	}


}
