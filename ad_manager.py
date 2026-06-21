import time
import hashlib

class AdManager:
    """
    AdManager handles AdMob advertisement state, delivery states, session limits,
    and a secure cryptographic developer bypass gate to disable ads.
    """
    def __init__(self, master_hash: str = None):
        # Default SHA-256 hash of the master password "StudyMasteryPremiumPass"
        # SHA-256: 0a6eb6ea04c107be6632c02058fbdf7a7604ad539a2d27bbb8e38d9db5a2aa52
        if master_hash is None:
            self.master_hash = "0a6eb6ea04c107be6632c02058fbdf7a7604ad539a2d27bbb8e38d9db5a2aa52"
        else:
            self.master_hash = master_hash

        # Persistent preferences/state configuration (mock local database/prefs)
        self.config = {
            "premium_ads_disabled": False
        }

        # Session & Cooldown State Variables
        self.last_video_ad_time = 0.0          # Unix timestamp of last video impression
        self.video_ads_shown_this_session = 0 # Count of video ads shown in current session
        self.video_cooldown_seconds = 1800     # 30 minutes lock duration

        # Tap counter state for bypass gate
        self.footer_tap_count = 0

    def verify_premium_key(self, input_string: str) -> bool:
        """
        Receives user input text, strips whitespace, converts it to SHA-256,
        validates it against the key, and saves the persistent state.
        """
        try:
            cleaned_input = input_string.strip()
            hashed_input = hashlib.sha256(cleaned_input.encode('utf-8')).hexdigest()
            
            if hashed_input == self.master_hash:
                self.config["premium_ads_disabled"] = True
                return True
            return False
        except Exception as e:
            print(f"Error in verify_premium_key: {e}")
            return False

    def on_click_settings_footer(self) -> bool:
        """
        Tracks sequential clicks on settings footer element.
        If clicks reach exactly 7, reset counter to zero and notify interface
        to launch premium authorization challenge overlay.
        """
        try:
            self.footer_tap_count += 1
            if self.footer_tap_count == 7:
                self.footer_tap_count = 0
                return True # Trigger overlay
            return False
        except Exception as e:
            print(f"Error in on_click_settings_footer: {e}")
            return False

    def should_display_ad(self, ad_type: str) -> bool:
        """
        Checks whether an ad of ad_type should be displayed, considering
        premium status, cooldown, and limits.
        Supported ad_types: 'BANNER', 'INTERSTITIAL', 'VIDEO'
        """
        try:
            # Rule 4: If premium bypass is active, suppress all ads
            if self.config.get("premium_ads_disabled", False):
                return False

            if ad_type == 'BANNER':
                # Rule 1: Always allow banner ads on Settings & Profile Page
                return True

            elif ad_type == 'INTERSTITIAL':
                # Rule 3: Always allow interstitials during transitions (Quiz/Analytics)
                return True

            elif ad_type == 'VIDEO':
                # Rule 2: Enforce a strict limit of one video ad per session and 30-min cooldown
                if self.video_ads_shown_this_session >= 1:
                    current_time = time.time()
                    elapsed = current_time - self.last_video_ad_time
                    if elapsed < self.video_cooldown_seconds:
                        return False
                return True

            return False
        except Exception as e:
            print(f"Error in should_display_ad: {e}")
            return False

    def record_ad_impression(self, ad_type: str):
        """
        Records a successful ad impression to update session tracking state.
        """
        try:
            if ad_type == 'VIDEO':
                self.last_video_ad_time = time.time()
                self.video_ads_shown_this_session += 1
        except Exception as e:
            print(f"Error in record_ad_impression: {e}")
